package secondProject.secondProject.dto;

import lombok.Getter;
import lombok.Setter;
import secondProject.secondProject.entity.Image;

import java.util.List;

@Getter
@Setter
public class ProductDTO {
    private String name;
    private Long category_id;

    private List<Image> images; //la entidad imagenes existe solo por su padre product
}
