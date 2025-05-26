package springboot.spring_data_jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springboot.spring_data_jpa.model.DTO.UserDTO;
import springboot.spring_data_jpa.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Integer id) {
        return userService.getUserByIdAfterCommit(id);
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserDTO create(@RequestBody UserDTO dto) {
        return userService.createUser(dto);
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Integer id, @RequestBody UserDTO dto) {
        return userService.updateUser(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
