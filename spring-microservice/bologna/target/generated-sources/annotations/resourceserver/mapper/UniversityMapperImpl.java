package resourceserver.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import resourceserver.dto.UniversityDTO;
import resourceserver.dto.UniversityMajorDepartmentDTO;
import resourceserver.model.university.University;
import resourceserver.model.university.UniversityMajorDepartment;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.7 (JetBrains s.r.o.)"
)
@Component
public class UniversityMapperImpl implements UniversityMapper {

    @Override
    public UniversityDTO toUniversityDTO(University university) {
        if ( university == null ) {
            return null;
        }

        UniversityDTO universityDTO = new UniversityDTO();

        universityDTO.setUniversity_id( university.getUniversity_id() );
        universityDTO.setName( university.getName() );
        universityDTO.setAddress( university.getAddress() );
        universityDTO.setAbout( university.getAbout() );
        universityDTO.setType( university.getType() );

        return universityDTO;
    }

    @Override
    public List<UniversityDTO> toUniversityDTOs(List<University> universities) {
        if ( universities == null ) {
            return null;
        }

        List<UniversityDTO> list = new ArrayList<UniversityDTO>( universities.size() );
        for ( University university : universities ) {
            list.add( toUniversityDTO( university ) );
        }

        return list;
    }

    @Override
    public University toUniversity(UniversityDTO universityDTO) {
        if ( universityDTO == null ) {
            return null;
        }

        University university = new University();

        university.setUniversity_id( universityDTO.getUniversity_id() );
        university.setName( universityDTO.getName() );
        university.setAddress( universityDTO.getAddress() );
        university.setAbout( universityDTO.getAbout() );
        university.setType( universityDTO.getType() );

        return university;
    }

    @Override
    public UniversityMajorDepartmentDTO toUniversityMajorDepartmentDTO(UniversityMajorDepartment universityMajorDepartment) {
        if ( universityMajorDepartment == null ) {
            return null;
        }

        UniversityMajorDepartmentDTO universityMajorDepartmentDTO = new UniversityMajorDepartmentDTO();

        universityMajorDepartmentDTO.setMajor_department_id( universityMajorDepartment.getMajor_department_id() );
        universityMajorDepartmentDTO.setMajor_department_name( universityMajorDepartment.getMajor_department_name() );
        universityMajorDepartmentDTO.setUniversity( universityMajorDepartment.getUniversity() );

        return universityMajorDepartmentDTO;
    }
}
