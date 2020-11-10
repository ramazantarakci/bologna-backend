package resourceserver.mapper;

import org.mapstruct.Mapper;
import resourceserver.dto.UniversitySemesterDTO;
import resourceserver.model.university.UniversitySemester;

import java.util.List;

@Mapper
public interface UniversitySemesterMapper {
    UniversitySemesterDTO toUniversitySemesterDTO(UniversitySemester universitySemester);
    UniversitySemester toUniversitySemester(UniversitySemesterDTO universitySemesterDTO);
//    List<UniversitySemesterDTO> toUniversitySemesterDTOs(List<UniversitySemester> universitySemesters);
}
