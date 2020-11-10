package resourceserver.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import resourceserver.dto.UniversityDepartmentDTO;
import resourceserver.model.university.UniversityDepartment;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.7 (JetBrains s.r.o.)"
)
@Component
public class UniversityDepartmentMapperImpl implements UniversityDepartmentMapper {

    @Override
    public UniversityDepartmentDTO toUniversityDepartmentDTO(UniversityDepartment universityDepartment) {
        if ( universityDepartment == null ) {
            return null;
        }

        UniversityDepartmentDTO universityDepartmentDTO = new UniversityDepartmentDTO();

        universityDepartmentDTO.setDepartment_id( universityDepartment.getDepartment_id() );
        universityDepartmentDTO.setDepartment_name( universityDepartment.getDepartment_name() );

        return universityDepartmentDTO;
    }

    @Override
    public List<UniversityDepartmentDTO> toUniversityDepartmentDTOs(List<UniversityDepartment> universityDepartments) {
        if ( universityDepartments == null ) {
            return null;
        }

        List<UniversityDepartmentDTO> list = new ArrayList<UniversityDepartmentDTO>( universityDepartments.size() );
        for ( UniversityDepartment universityDepartment : universityDepartments ) {
            list.add( toUniversityDepartmentDTO( universityDepartment ) );
        }

        return list;
    }
}
