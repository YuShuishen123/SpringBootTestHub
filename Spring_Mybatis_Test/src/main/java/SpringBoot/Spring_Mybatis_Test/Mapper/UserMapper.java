package SpringBoot.Spring_Mybatis_Test.Mapper;

import SpringBoot.Spring_Mybatis_Test.DO.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Yu'S'hui'shen
 */
@Mapper
public interface UserMapper {

    //    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectById(int id);

//    @Insert("INSERT INTO user (name, age, email) VALUES (#{name}, #{age}, #{email})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);
}
