package resourceserver.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import resourceserver.dto.UniversityMajorDepartmentDTO;
import resourceserver.model.university.UniversityMajorDepartment;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.7 (JetBrains s.r.o.)"
)
@Component
public class UniversityMajorDepartmentMapperImpl implements UniversityMajorDepartmentMapper {

    @Override
    public List<UniversityMajorDepartmentDTO> toUniversityMajorDepartmentDTOs(List<UniversityMajorDepartment> universityMajorDepartments) {
        if ( universityMajorDepartments == null ) {
            return null;
        }

        List<UniversityMajorDepartmentDTO> list = new ArrayList<UniversityMajorDepartmentDTO>( universityMajorDepartments.size() );
        for ( UniversityMajorDepartment universityMajorDepartment : universityMajorDepartments ) {
            list.add( toUniversityMajorDepartmentDTO( universityMajorDepartment ) );
        }

        return list;
    }

    @Override
    public UniversityMajorDepartmentDTO toUniversityMajorDepartmentDTO(UniversityMajorDepartment majorDepartment) {
        if ( majorDepartment == null ) {
            return null;
        }

        UniversityMajorDepartmentDTO universityMajorDepartmentDTO = new UniversityMajorDepartmentDTO();

        universityMajorDepartmentDTO.setMajor_department_id( majorDepartment.getMajor_department_id() );
        universityMajorDepartmentDTO.setMajor_department_name( majorDepartment.getMajor_department_name() );
        universityMajorDepartmentDTO.setUniversity( majorDepartment.getUniversity() );

        return universityMajorDepartmentDTO;
    }
}
