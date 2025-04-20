package SpringBoot.Spring_Mybatis_Homework.mapper;

import SpringBoot.Spring_Mybatis_Homework.DO.IdCard;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * @author Yu'S'hui'shen
 */
@Mapper
public interface IdCardMapper{
    // 一对一:用户（users）与身份证信息（id_cards）

    // 根据用户ID,查询用户身份证信息
    IdCard selectIdCardByUserId(Integer userId);

    // 删除用户身份证信息
    int deleteIdCardByUserId(Integer userId);

    // 插入用户身份证信息
    int insertIdCardByUserId(Integer userId, String cardNumber, Date issueDate);

    // 修改用户身份证信息
    int updateIdCardByUserId(Integer userId, String cardNumber, Date issueDate);
}
