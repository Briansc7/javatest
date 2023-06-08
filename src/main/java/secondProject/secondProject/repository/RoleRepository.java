package secondProject.secondProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import secondProject.secondProject.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
