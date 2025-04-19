package SpringBoot.Spring_Mybatis_Test.Mapper;


import SpringBoot.Spring_Mybatis_Test.DO.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Yu'S'hui'shen
 */
@Mapper
public interface StudentMapper {

    Student getById(Integer id);

    void insert(Student student);

    int deleteById(Integer id);
}
