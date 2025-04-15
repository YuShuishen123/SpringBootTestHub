package springboot.springbootaop_demo.service;


import org.springframework.stereotype.Service;
import springboot.springbootaop_demo.DTO.UserDTO;

/**
 * @author Yu'S'hui'shen
 */
@Service
public interface  UserService {
    /* 可能因数据库连接失败抛 DataAccessException */
    public UserDTO findById(int userId);

    /* 可能因唯一约束冲突抛 DataIntegrityViolationException */
    public int save(UserDTO user);

    /* 可能因ID不存在抛 EmptyResultDataAccessException */
    public int delete(int userId);
}
