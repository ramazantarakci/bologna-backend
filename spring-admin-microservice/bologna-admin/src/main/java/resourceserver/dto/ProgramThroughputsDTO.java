package resourceserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import resourceserver.dto.subdto.PT;
import resourceserver.model.university.UniversityDepartment;
import java.util.List;

@Data
public class ProgramThroughputsDTO  extends RepresentationModel<ProgramThroughputsDTO> {
    @JsonIgnore
    private UniversityDepartment universityDepartment;

    private int department_id;
    private List<PT> ptList;
}
