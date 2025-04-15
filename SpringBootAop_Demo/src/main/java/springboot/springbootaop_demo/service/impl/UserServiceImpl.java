package springboot.springbootaop_demo.service.impl;

import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import springboot.springbootaop_demo.DTO.UserDTO;
import springboot.springbootaop_demo.service.UserService;

/**
 * @author Yu'S'hui'shen
 */

@Component
public class UserServiceImpl implements UserService {
    /**
     * @param userId 用户id
     * @return 用户
     */
    @Override
    public UserDTO findById(int userId) {
        if (userId == 0) {
            // 使用具体的非抽象异常
            throw new DataAccessResourceFailureException("非法用户ID: " + userId);
        }
        return new UserDTO(userId, "testName");
    }

    /**
     * @param user 用户DTO
     * @return 数据库操作结果
     */
    @Override
    public int save(UserDTO user) {
        if(user.getUserId() == 0){
            throw new DataIntegrityViolationException("用户已存在");
        }
        return 1;
    }

    /**
     * @param userId 用户id
     * @return 数据库操作结果
     */
    @Override
    public int delete(int userId) {
        if(userId == 0){
            throw new EmptyResultDataAccessException("用户不存在 " , userId);
        }
        return 1;
    }
}
