package springboot.spring_data_jpa.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.spring_data_jpa.model.DTO.UserDTO;
import springboot.spring_data_jpa.model.entity.IdCard;
import springboot.spring_data_jpa.model.entity.User;
import springboot.spring_data_jpa.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;

    @PersistenceContext
    private EntityManager entityManager;

    private UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());

        if (user.getIdCard() != null) {
            dto.setCardNumber(user.getIdCard().getCardNumber());
            dto.setIssueDate(user.getIdCard().getIssueDate());
        }
        return dto;
    }

    @Transactional
    public List<UserDTO> getAllUsers() {
        List<UserDTO> list = new ArrayList<>();
        for (User user : userRepo.findAll()) {
            UserDTO dto = toDTO(user);
            list.add(dto);
        }
        return list;
    }

    @Transactional
    public UserDTO createUser(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        IdCard card = new IdCard();
        card.setCardNumber(dto.getCardNumber());
        card.setUser(user);
        user.setIdCard(card);

        User savedUser = userRepo.save(user);
        userRepo.flush();
        entityManager.refresh(savedUser);
        return toDTO(savedUser);
    }

    @Transactional
    public UserDTO getUserByIdAfterCommit(Integer id) {
        return userRepo.findById(id).map(this::toDTO).orElse(null);
    }

    @Transactional
    public UserDTO updateUser(Integer id, UserDTO dto) {
        Optional<User> optional = userRepo.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        User user = optional.get();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        if (user.getIdCard() != null) {
            user.getIdCard().setCardNumber(dto.getCardNumber());
            user.getIdCard().setIssueDate(dto.getIssueDate());
        }

        userRepo.flush();
        entityManager.refresh(user);

        return toDTO(user);
    }

    @Transactional
    public void deleteUser(Integer id) {
        userRepo.deleteById(id);
    }
}
