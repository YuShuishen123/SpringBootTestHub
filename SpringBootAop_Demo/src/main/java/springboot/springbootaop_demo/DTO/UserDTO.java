package springboot.springbootaop_demo.DTO;

import lombok.Data;

/**
 * @author Yu'S'hui'shen
 */

@Data
public class UserDTO {
    String name;
    int userId;
    // 无参构造（显式定义）
    public UserDTO() {}

    // 有参构造
    public UserDTO(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

}
