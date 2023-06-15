package secondProject.secondProject.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import secondProject.secondProject.entity.Category;
import secondProject.secondProject.entity.Image;
import secondProject.secondProject.entity.Role;
import secondProject.secondProject.service.CategoryService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
@Validated
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Category category){

        categoryService.create(category);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category Successfully created") ;

    }

    @GetMapping("/list")
    public List<Category> list(){
        return categoryService.list();
    }
}
