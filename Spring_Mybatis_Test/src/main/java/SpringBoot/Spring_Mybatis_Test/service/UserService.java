package SpringBoot.Spring_Mybatis_Test.service;

import SpringBoot.Spring_Mybatis_Test.DO.User;

/**
 * @author Yu'S'hui'shen
 */
public interface UserService {

    User selectById(int id);

    int insert(User user);
}

