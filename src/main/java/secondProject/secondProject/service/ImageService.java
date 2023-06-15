package secondProject.secondProject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import secondProject.secondProject.entity.Image;
import secondProject.secondProject.repository.ImageRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public List<Image> list(){
        return imageRepository.findAll();
    }
}
