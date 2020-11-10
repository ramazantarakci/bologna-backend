package resourceserver.dto.subdto;

import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UniversityNameListDTO {//extends RepresentationModel<UniversityNameListDTO>
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int university_id;
    private String name;
}
