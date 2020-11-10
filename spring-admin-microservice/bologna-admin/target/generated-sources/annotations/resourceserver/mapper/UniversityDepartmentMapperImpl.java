package resourceserver.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import resourceserver.dto.UniversityDepartmentDTO;
import resourceserver.dto.subdto.PT;
import resourceserver.dto.subdto.UpdatePT;
import resourceserver.model.university.ProgramThroughputs;
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
        universityDepartmentDTO.setDepartment_about( universityDepartment.getDepartment_about() );
        universityDepartmentDTO.setUniversityMajorDepartment( universityDepartment.getUniversityMajorDepartment() );

        return universityDepartmentDTO;
    }

    @Override
    public UniversityDepartment toUniversityDepartment(UniversityDepartmentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UniversityDepartment universityDepartment = new UniversityDepartment();

        universityDepartment.setDepartment_id( dto.getDepartment_id() );
        universityDepartment.setDepartment_name( dto.getDepartment_name() );
        universityDepartment.setDepartment_about( dto.getDepartment_about() );
        universityDepartment.setUniversityMajorDepartment( dto.getUniversityMajorDepartment() );

        return universityDepartment;
    }

    @Override
    public ProgramThroughputs toProgramThroughputs(PT pt) {
        if ( pt == null ) {
            return null;
        }

        ProgramThroughputs programThroughputs = new ProgramThroughputs();

        programThroughputs.setId( pt.getId() );
        programThroughputs.setThroughput_id( pt.getThroughput_id() );
        programThroughputs.setThroughput_content( pt.getThroughput_content() );
        programThroughputs.setUniversityDepartment( pt.getUniversityDepartment() );

        return programThroughputs;
    }

    @Override
    public ProgramThroughputs toProgramThroughputs(UpdatePT pt) {
        if ( pt == null ) {
            return null;
        }

        ProgramThroughputs programThroughputs = new ProgramThroughputs();

        programThroughputs.setId( pt.getId() );
        programThroughputs.setThroughput_id( pt.getThroughput_id() );
        programThroughputs.setThroughput_content( pt.getThroughput_content() );
        programThroughputs.setUniversityDepartment( pt.getUniversityDepartment() );

        return programThroughputs;
    }
}
