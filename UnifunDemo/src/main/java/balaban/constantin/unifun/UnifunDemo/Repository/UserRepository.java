package balaban.constantin.unifun.UnifunDemo.Repository;

import balaban.constantin.unifun.UnifunDemo.Model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("select u from User u where u.firstName = ?1 and u.lastName = ?2")
    List<User> searchByFirstAndLastName(String firstName, String lastName);
}
