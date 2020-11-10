package resourceserver.dto.listdto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import resourceserver.model.embedable.University_type;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UniversityListDTO extends RepresentationModel<UniversityListDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int university_id;
    private String name;
    private University_type type;
}
