package resourceserver.mapper;

import org.mapstruct.Mapper;
import resourceserver.dto.UniversityDTO;
import resourceserver.dto.UniversityMajorDepartmentDTO;
import resourceserver.model.university.University;
import resourceserver.model.university.UniversityMajorDepartment;

import java.util.List;

@Mapper
public interface UniversityMapper {
    UniversityDTO toUniversityDTO(University university);
    List<UniversityDTO> toUniversityDTOs(List<University> universities);
    University toUniversity(UniversityDTO universityDTO);
    UniversityMajorDepartmentDTO toUniversityMajorDepartmentDTO(UniversityMajorDepartment universityMajorDepartment);
}
