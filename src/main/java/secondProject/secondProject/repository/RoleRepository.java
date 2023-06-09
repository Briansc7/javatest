package secondProject.secondProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import secondProject.secondProject.entity.Role;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select r FROM Role r where r.name = ?1")
    public Optional<Role> findByRoleName(String name);
}
