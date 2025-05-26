package springboot.spring_data_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.spring_data_jpa.model.entity.IdCard;

/**
 * 身份证持久层
 *
 * @author Yu'S'hui'shen
 */
@Repository
public interface IdCardRepository extends JpaRepository<IdCard, Integer> {
}
