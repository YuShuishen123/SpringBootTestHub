package SpringBoot.Spring_Mybatis_Homework.DO;

import lombok.Data;

import java.util.Date;

/**
 * @author Yu'S'hui'shen
 */
@Data
public class IdCard {
    private Integer cardId;
    private String cardNumber;
    private Date issueDate;
    private Integer userId;

    // 增加User 属性,用于映射用户
    private  User user;
}
