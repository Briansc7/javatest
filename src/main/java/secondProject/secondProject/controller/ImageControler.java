package secondProject.secondProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import secondProject.secondProject.entity.Image;
import secondProject.secondProject.entity.Role;
import secondProject.secondProject.service.ImageService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/image")
@Validated
public class ImageControler {
    private final ImageService imageService;

    @GetMapping("/list")
    public List<Image> list(){
        return imageService.list();
    }
}
