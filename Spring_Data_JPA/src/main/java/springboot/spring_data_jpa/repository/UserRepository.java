package springboot.spring_data_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.spring_data_jpa.model.entity.User;

/**
 * 继承JpaRepository,实现持久层接口
 *
 * @author Yu'S'hui'shen
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
