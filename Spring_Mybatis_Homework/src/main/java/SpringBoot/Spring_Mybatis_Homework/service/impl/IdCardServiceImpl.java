package SpringBoot.Spring_Mybatis_Homework.service.impl;

import SpringBoot.Spring_Mybatis_Homework.DO.IdCard;
import SpringBoot.Spring_Mybatis_Homework.mapper.IdCardMapper;
import SpringBoot.Spring_Mybatis_Homework.service.IdCardService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Yu'S'hui'shen
 */

@Service
public class IdCardServiceImpl implements IdCardService {

    private final IdCardMapper idCardMapper;

    public IdCardServiceImpl(IdCardMapper idCardMapper) {
        this.idCardMapper = idCardMapper;
    }
    @Override
    public int insertIdCardByUserId(Integer userId, String cardNumber, Date issueDate) {
        return idCardMapper.insertIdCardByUserId(userId, cardNumber, issueDate);
    }

    @Override
    public int updateIdCardByUserId(Integer userId, String cardNumber, Date issueDate) {
        return idCardMapper.updateIdCardByUserId(userId, cardNumber, issueDate);
    }

    @Override
    public int deleteIdCardByUserId(Integer userId) {
        return idCardMapper.deleteIdCardByUserId(userId);
    }

    @Override
    public IdCard selectIdCardByUserId(Integer userId) {
        return idCardMapper.selectIdCardByUserId(userId);
    }
}
