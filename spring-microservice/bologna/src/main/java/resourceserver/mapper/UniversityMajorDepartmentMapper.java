package resourceserver.mapper;

import org.mapstruct.Mapper;
import resourceserver.dto.UniversityDepartmentDTO;
import resourceserver.dto.UniversityMajorDepartmentDTO;
import resourceserver.model.university.UniversityMajorDepartment;

import java.util.List;

@Mapper
public interface UniversityMajorDepartmentMapper {
    List<UniversityMajorDepartmentDTO> toUniversityMajorDepartmentDTOs(List<UniversityMajorDepartment> universityMajorDepartments);
    UniversityMajorDepartmentDTO toUniversityMajorDepartmentDTO(UniversityMajorDepartment majorDepartment);
}
