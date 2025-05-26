package springboot.spring_data_jpa.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "id_cards")
@Data
public class IdCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Integer cardId;

    @Column(name = "card_number", nullable = false, length = 18, unique = true)
    private String cardNumber;

    @Column(name = "issue_date", insertable = false, updatable = false)
    private LocalDateTime issueDate;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
}
