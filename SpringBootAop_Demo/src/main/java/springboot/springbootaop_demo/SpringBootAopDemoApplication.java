package springboot.springbootaop_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Yu'S'hui'shen
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringBootAopDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopDemoApplication.class, args);
    }

}
