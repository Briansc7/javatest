package secondProject.secondProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import secondProject.secondProject.entity.Product;

//repositorio siempre apuntar a la entidad
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
