package SpringBoot.Spring_Mybatis_Test.service.impl;

import SpringBoot.Spring_Mybatis_Test.DO.User;
import SpringBoot.Spring_Mybatis_Test.Mapper.UserMapper;
import SpringBoot.Spring_Mybatis_Test.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Yu'S'hui'shen
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User selectById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
}

