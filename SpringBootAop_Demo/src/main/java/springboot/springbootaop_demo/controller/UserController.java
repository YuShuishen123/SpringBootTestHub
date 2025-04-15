package springboot.springbootaop_demo.controller;


import org.springframework.web.bind.annotation.*;
import springboot.springbootaop_demo.DTO.UserDTO;
import springboot.springbootaop_demo.service.UserService;

/**
 * @author Yu'S'hui'shen
 */
@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public UserDTO getUserById(@RequestParam("userId") int userId){
        return userService.findById(userId);
    }

    @PutMapping("/saveUser")
    public int saveUsers(@RequestParam("userId") int userId,
                         @RequestParam("userName") String userName){
        return userService.save(new UserDTO(userId,userName));
    }

    @DeleteMapping("/deleteUser")
    public int deleteUsers(@RequestParam("userId") int userId) {
        return userService.delete(userId);
    }
}
