package resourceserver.mapper;

import org.mapstruct.Mapper;
import resourceserver.dto.UniversityDTO;
import resourceserver.dto.subdto.UniversityNameListDTO;
import resourceserver.dto.listdto.UniversityListDTO;
import resourceserver.model.university.University;

import java.util.List;

@Mapper
public interface UniversityMapper {
    UniversityDTO toUniversityDTO(University university);
    UniversityListDTO toUniversityListDTO(University university);
    University toUniversity(UniversityDTO dto);
    University toUniversity(UniversityListDTO dto);
    List<UniversityNameListDTO> toUniversityNameListDTO(List<University> universities);
//    UniversityMajorDepartmentDTO toUniversityMajorDepartmentDTO(UniversityMajorDepartment universityMajorDepartment);
//    List<UniversityDTO> toUniversityDTOs(List<University> universities);
}
