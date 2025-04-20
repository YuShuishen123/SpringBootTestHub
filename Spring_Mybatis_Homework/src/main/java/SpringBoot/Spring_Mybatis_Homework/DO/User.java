package SpringBoot.Spring_Mybatis_Homework.DO;

import lombok.Data;

import java.sql.Timestamp;


/**
 * @author Yu'S'hui'shen
 */
@Data
public class User {
    private Integer userId;
    private String username;
    private String email;
    private Timestamp createdAt;
}
