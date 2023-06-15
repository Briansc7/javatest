package secondProject.secondProject.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import secondProject.secondProject.entity.Category;
import secondProject.secondProject.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> getById(Long id){
        return categoryRepository.findById(id);
    }

    public Category create(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> list(){
        return categoryRepository.findAll();
    }
}
