package resourceserver.mapper;

import org.mapstruct.Mapper;
import resourceserver.dto.UniversityDepartmentDTO;
//import resourceserver.dto.fielddto.ProgramThroughputsDTO;
import resourceserver.dto.subdto.PT;
import resourceserver.dto.subdto.UpdatePT;
import resourceserver.model.university.ProgramThroughputs;
import resourceserver.model.university.UniversityDepartment;

@Mapper
public interface UniversityDepartmentMapper {
    UniversityDepartmentDTO toUniversityDepartmentDTO(UniversityDepartment universityDepartment);
    UniversityDepartment toUniversityDepartment(UniversityDepartmentDTO dto);
    ProgramThroughputs toProgramThroughputs(PT pt);
    ProgramThroughputs toProgramThroughputs(UpdatePT pt);
//    List<UniversityDepartmentDTO> toUniversityDepartmentDTOs(List<UniversityDepartment> universityDepartments);
    //AboutDTO toAboutDTO(UniversityDepartment universityDepartment);
   // ProgramThroughputsDTO toProgramThroughputsDTO(UniversityDepartment universityDepartment);
}
