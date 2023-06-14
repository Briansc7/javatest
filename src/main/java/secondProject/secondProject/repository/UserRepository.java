package secondProject.secondProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import secondProject.secondProject.entity.Role;
import secondProject.secondProject.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u FROM User u where u.role.name = ?1")
    public List<User> findByRoleName(String nameRole);
}
