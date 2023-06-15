package secondProject.secondProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import secondProject.secondProject.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
