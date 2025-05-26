package springboot.spring_data_jpa.model.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Integer userId;
    private String username;
    private String email;
    private LocalDateTime createdAt;
    private String cardNumber;
    private LocalDateTime issueDate;
}
