package springboot.spring_redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import springboot.spring_redis.model.entity.Product;

/**
 * @author Yu'S'hui'shen
 * @description 针对表【product(商品表)】的数据库操作Service
 * @createDate 2025-05-26 22:38:03
 */
@Service
public interface ProductService extends IService<Product> {


}
