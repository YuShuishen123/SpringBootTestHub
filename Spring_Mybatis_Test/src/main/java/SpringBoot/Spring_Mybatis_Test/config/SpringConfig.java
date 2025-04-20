package SpringBoot.Spring_Mybatis_Test.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Yu'S'hui'shen
 */
@Configuration
@ComponentScan("SpringBoot.Spring_Mybatis_Test.service")
@EnableTransactionManagement
@MapperScan("SpringBoot.Spring_Mybatis_Test.Mapper")
@PropertySource("classpath:jdbc.properties")
@SpringBootApplication
public class SpringConfig {}
