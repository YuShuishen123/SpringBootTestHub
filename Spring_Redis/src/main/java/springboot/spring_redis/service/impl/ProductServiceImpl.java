package springboot.spring_redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import springboot.spring_redis.mapper.ProductMapper;
import springboot.spring_redis.model.entity.Product;
import springboot.spring_redis.service.ProductService;

/**
 * @author Yu'S'hui'shen
 * @description 针对表【product(商品表)】的数据库操作Service实现
 * @createDate 2025-05-26 22:38:03
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
        implements ProductService {

}




