package resourceserver.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import resourceserver.model.embedable.University_type;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UniversityDTO extends RepresentationModel<UniversityDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int university_id;
    private String name;
    private String address;
    private String about;
    private University_type type;
}
