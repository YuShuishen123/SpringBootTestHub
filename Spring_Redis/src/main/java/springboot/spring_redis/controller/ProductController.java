package springboot.spring_redis.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.web.bind.annotation.*;
import springboot.spring_redis.common.BaseResponse;
import springboot.spring_redis.common.ResultUtils;
import springboot.spring_redis.exception.BusinessException;
import springboot.spring_redis.exception.ErrorCode;
import springboot.spring_redis.exception.ThrowUtils;
import springboot.spring_redis.manager.CacheClient;
import springboot.spring_redis.model.DTO.ProductOperationRequest;
import springboot.spring_redis.model.entity.Product;
import springboot.spring_redis.service.ProductService;

import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Yu'S'hui'shen
 * @date 2025/5/26
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    private static final String CACHE_KEY_PRODUCT = "product:";
    private static final Long TTL = 60L;
    @Resource
    private ProductService productService;
    @Resource
    private CacheClient cacheClient;

    /**
     * 获取对象中值为 null 的属性名
     *
     * @param source 源对象
     * @return null 值的属性名数组
     */
    private static String[] getNullPropertyNames(Object source) {
        BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        List<String> nullPropertyNames = new ArrayList<>();
        for (PropertyDescriptor pd : pds) {
            if (src.getPropertyValue(pd.getName()) == null || "".equals(src.getPropertyValue(pd.getName()))) {
                nullPropertyNames.add(pd.getName());
            }
        }
        return nullPropertyNames.toArray(new String[0]);
    }

    /**
     * 查询所有商品
     *
     * @return 商品列表
     */
    @PostMapping("/list")
    public BaseResponse<List<Product>> getPictureList() {
        // 生成唯一key
        String cacheKey = CACHE_KEY_PRODUCT + "allproductlist";
        List<Product> productList = cacheClient.queryWithCache(
                cacheKey,
                new TypeReference<>() {
                },
                Duration.ofMinutes(TTL),
                () -> productService.list()
        );
        return ResultUtils.success(productList);
    }

    /**
     * 根据id查询商品
     *
     * @param id 商品id
     * @return 商品
     */
    @GetMapping("/get")
    public BaseResponse<Product> getProductById(Long id) {
        String cacheKey = CACHE_KEY_PRODUCT + "productid:" + id;
        Product product = cacheClient.queryWithCache(
                cacheKey,
                new TypeReference<>() {
                },
                Duration.ofMinutes(TTL),
                () -> productService.getById(id)
        );
        return ResultUtils.success(product);
    }

    /**
     * 添加商品
     *
     * @param productOperationRequest 商品
     * @return 添加结果
     */
    @PostMapping("/add")
    public BaseResponse<Boolean> addProduct(@RequestBody ProductOperationRequest productOperationRequest) {
        Product product = new Product();
        BeanUtils.copyProperties(productOperationRequest, product);
        if (productService.save(product)) {
            log.info("添加成功,id:{}", product.getId());
            String cacheKey = CACHE_KEY_PRODUCT + "productid:" + product.getId();
            cacheClient.update(cacheKey, product, Duration.ofMinutes(TTL));
            return ResultUtils.success(true);
        }
        throw new BusinessException(ErrorCode.OPERATION_ERROR);
    }

    /**
     * 修改商品
     *
     * @param productOperationRequest 商品更新信息
     * @return 修改结果
     */
    @PostMapping("/update")
    public BaseResponse<Product> updateProduct(@RequestBody ProductOperationRequest productOperationRequest) {
        // 1. 参数校验
        ThrowUtils.throwIf(
                productOperationRequest == null
                        || productOperationRequest.getId() == null
                        || productOperationRequest.getId() <= 0
                        || StringUtils.isBlank(productOperationRequest.getName())
                        || productOperationRequest.getPrice() == null
                        || productOperationRequest.getPrice().compareTo(BigDecimal.ZERO) <= 0,
                ErrorCode.PARAMS_ERROR, "商品参数不合法");

        // 2. 查询商品（从缓存或数据库）
        Product oldProduct;
        oldProduct = cacheClient.queryWithCache(
                CACHE_KEY_PRODUCT + "productid:" + productOperationRequest.getId(),
                new TypeReference<>() {
                },
                Duration.ofMinutes(TTL),
                () -> productService.getById(productOperationRequest.getId())
        );
        ThrowUtils.throwIf(oldProduct == null, ErrorCode.NOT_FOUND_ERROR, "商品不存在");

        // 3. 复制请求参数到旧商品对象，忽略 null 值
        BeanUtils.copyProperties(productOperationRequest, oldProduct, getNullPropertyNames(productOperationRequest));

        // 4. 更新数据库
        boolean updateSuccess = productService.updateById(oldProduct);
        ThrowUtils.throwIf(!updateSuccess, ErrorCode.OPERATION_ERROR, "商品更新失败");

        // 5. 更新缓存
        String cacheKey = CACHE_KEY_PRODUCT + "productid:" + oldProduct.getId();
        cacheClient.update(cacheKey, oldProduct, Duration.ofMinutes(TTL));

        return ResultUtils.success(oldProduct);
    }

    /**
     * 删除商品
     *
     * @param id 商品id
     * @return 删除结果
     */
    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteProduct(Long id) {
        ThrowUtils.throwIf(id == null || id <= 0, ErrorCode.PARAMS_ERROR);
        // 判断数据库中商品是否存在
        String key = CACHE_KEY_PRODUCT + "productid:" + id;
        Product product = cacheClient.queryWithCache(key, new TypeReference<>() {
        }, Duration.ofMinutes(TTL), () -> productService.getById(id));
        ThrowUtils.throwIf(product == null, ErrorCode.NOT_FOUND_ERROR);
        cacheClient.invalidate(key);
        return ResultUtils.success(productService.removeById(id));
    }

}
