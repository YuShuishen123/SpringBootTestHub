package SpringBoot.Spring_Mybatis_Homework.service;

import SpringBoot.Spring_Mybatis_Homework.DO.IdCard;

import java.util.Date;

/**
 * @author Yu'S'hui'shen
 */

public interface IdCardService {

    int insertIdCardByUserId(Integer userId, String cardNumber, Date issueDate);

    int updateIdCardByUserId(Integer userId, String cardNumber, Date issueDate);

    int deleteIdCardByUserId(Integer userId);

    IdCard selectIdCardByUserId(Integer userId);
}
