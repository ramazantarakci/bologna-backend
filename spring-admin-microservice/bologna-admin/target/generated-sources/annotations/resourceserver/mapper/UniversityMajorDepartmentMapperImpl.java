package resourceserver.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import resourceserver.dto.UniversityMajorDepartmentDTO;
import resourceserver.dto.listdto.MajorDepartmentListDTO;
import resourceserver.model.university.UniversityMajorDepartment;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.7 (JetBrains s.r.o.)"
)
@Component
public class UniversityMajorDepartmentMapperImpl implements UniversityMajorDepartmentMapper {

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

    @Override
    public UniversityMajorDepartment toUniversityMajorDepartment(UniversityMajorDepartmentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UniversityMajorDepartment universityMajorDepartment = new UniversityMajorDepartment();

        universityMajorDepartment.setMajor_department_id( dto.getMajor_department_id() );
        universityMajorDepartment.setMajor_department_name( dto.getMajor_department_name() );
        universityMajorDepartment.setUniversity( dto.getUniversity() );

        return universityMajorDepartment;
    }

    @Override
    public List<MajorDepartmentListDTO> toMajorDepartmentListDTO(List<UniversityMajorDepartment> majorDepartmentList) {
        if ( majorDepartmentList == null ) {
            return null;
        }

        List<MajorDepartmentListDTO> list = new ArrayList<MajorDepartmentListDTO>( majorDepartmentList.size() );
        for ( UniversityMajorDepartment universityMajorDepartment : majorDepartmentList ) {
            list.add( universityMajorDepartmentToMajorDepartmentListDTO( universityMajorDepartment ) );
        }

        return list;
    }

    protected MajorDepartmentListDTO universityMajorDepartmentToMajorDepartmentListDTO(UniversityMajorDepartment universityMajorDepartment) {
        if ( universityMajorDepartment == null ) {
            return null;
        }

        MajorDepartmentListDTO majorDepartmentListDTO = new MajorDepartmentListDTO();

        majorDepartmentListDTO.setMajor_department_id( universityMajorDepartment.getMajor_department_id() );
        majorDepartmentListDTO.setMajor_department_name( universityMajorDepartment.getMajor_department_name() );

        return majorDepartmentListDTO;
    }
}
