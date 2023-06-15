package secondProject.secondProject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import secondProject.secondProject.dto.ProductDTO;
import secondProject.secondProject.entity.Category;
import secondProject.secondProject.entity.Image;
import secondProject.secondProject.entity.Product;
import secondProject.secondProject.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public Product create(ProductDTO productDTO){
        Product product = new Product();

        var name = productDTO.getName();

        product.setName(name);

        var category_id = productDTO.getCategory_id();

        Optional<Category> categoryFound = categoryService.getById(category_id);

        categoryFound.ifPresent(product::setCategory);

        List<Image> images = productDTO.getImages();

        product.setImages(images);

        return productRepository.save(product);

    }

    public List<Product> list() {
        return productRepository.findAll();
    }
}
