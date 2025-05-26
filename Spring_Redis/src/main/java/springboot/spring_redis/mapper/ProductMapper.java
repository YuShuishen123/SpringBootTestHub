package springboot.spring_redis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import springboot.spring_redis.model.entity.Product;

/**
 * @author Yu'S'hui'shen
 * @description 针对表【product(商品表)】的数据库操作Mapper
 * @createDate 2025-05-26 22:38:03
 */
@Mapper
@Repository
public interface ProductMapper extends BaseMapper<Product> {

}




