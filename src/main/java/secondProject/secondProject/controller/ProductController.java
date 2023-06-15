package secondProject.secondProject.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import secondProject.secondProject.dto.ProductDTO;
import secondProject.secondProject.entity.Category;
import secondProject.secondProject.entity.Product;
import secondProject.secondProject.service.CategoryService;
import secondProject.secondProject.service.ProductService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
@Validated
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody ProductDTO productDto) {



        Long category_id = productDto.getCategory_id();


        Optional<Category> category = categoryService.getById(category_id);




        if (category.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El idCategoria : " + category_id + " no pertenece a ninguna Categoria");
        }
        Product newProduct = productService.create(productDto);
        if (newProduct == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al intentar guardar el Producto.");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("El Producto se guardó con éxito");
    }

    @GetMapping("/list")
    public List<Product> list() {
        return productService.list();
    }
}
