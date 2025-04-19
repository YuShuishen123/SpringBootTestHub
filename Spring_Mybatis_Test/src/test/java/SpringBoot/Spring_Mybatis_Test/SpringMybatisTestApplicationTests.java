package SpringBoot.Spring_Mybatis_Test;

import SpringBoot.Spring_Mybatis_Test.DO.Student;
import SpringBoot.Spring_Mybatis_Test.Mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.Reader;

@SpringBootTest
class SpringMybatisTestApplicationTests {
	@Test
	void contextLoads() {
		String resource = "mybatis-config.xml";
		// 1.加载配置文件：初始化 MyBatis 的核心组件。

        try (Reader reader = Resources.getResourceAsReader(resource)) {

            // 2.创建 SqlSessionFactory 对象，初始化 MyBatis 的核心组件。
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            // 3.创建 SqlSession 对象，用于执行 SQL 语句。
            try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

                // 4.创建 StudentMapper 对象，用于执行 SQL 语句。
                StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

                // 插入
                Student student = new Student();
                student.setName("John Yu");
                student.setAge(30);
                student.setGender("男");

                // 5. 执行插入操作
                studentMapper.insert(student);

                /*执行删除操作*/
                studentMapper.deleteById(student.getId() - 1);

                // 6. 提交事务
                sqlSession.commit(); // 提交事务

                // 7. 查询用户
                Student insert = studentMapper.getById(student.getId());
                System.out.println("Inserted student: " + insert);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 8. 关闭资源
    }

}
