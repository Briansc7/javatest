package secondProject.secondProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import secondProject.secondProject.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
