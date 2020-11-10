package resourceserver.mapper;

import org.mapstruct.Mapper;
import resourceserver.dto.UniversityDepartmentDTO;
//import resourceserver.dto.fielddto.ProgramThroughputsDTO;
import resourceserver.model.university.UniversityDepartment;

import java.util.List;

@Mapper
public interface UniversityDepartmentMapper {
    UniversityDepartmentDTO toUniversityDepartmentDTO(UniversityDepartment universityDepartment);
    List<UniversityDepartmentDTO> toUniversityDepartmentDTOs(List<UniversityDepartment> universityDepartments);
    //AboutDTO toAboutDTO(UniversityDepartment universityDepartment);
   // ProgramThroughputsDTO toProgramThroughputsDTO(UniversityDepartment universityDepartment);
}
