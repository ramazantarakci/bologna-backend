package resourceserver.mapper;

import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import resourceserver.dto.UniversityMajorDepartmentDTO;
import resourceserver.dto.listdto.MajorDepartmentListDTO;
import resourceserver.model.university.University;
import resourceserver.model.university.UniversityMajorDepartment;
import resourceserver.service.UniversityService;
import java.util.List;

@Mapper
public interface UniversityMajorDepartmentMapper {
//    List<UniversityMajorDepartmentDTO> toUniversityMajorDepartmentDTOs(List<UniversityMajorDepartment> universityMajorDepartments);
    UniversityMajorDepartmentDTO toUniversityMajorDepartmentDTO(UniversityMajorDepartment majorDepartment);

//    @Mapping(source = "universityid", target = "university", qualifiedByName = "uidtou")
//    @Mapping(source = "universityid", ignore = true)
    UniversityMajorDepartment toUniversityMajorDepartment(UniversityMajorDepartmentDTO dto);
    List<MajorDepartmentListDTO> toMajorDepartmentListDTO(List<UniversityMajorDepartment> majorDepartmentList);


}

//@Component
//abstract class custommap implements UniversityMajorDepartmentMapper{
//    @Autowired
////    @Qualifier("universityService")
//    UniversityService universityService;
//    @Qualifier("")
//    @Autowired
////    @Qualifier("mapper")
//    UniversityMajorDepartmentMapper mapper;
//
//    @Override
//    @Named("deneme")
//    public UniversityMajorDepartment toUniversityMajorDepartment(UniversityMajorDepartmentDTO dto){
//        dto.setUniversity(universityService.findById(dto.getUniversityid()).get());
////        UniversityMajorDepartment department = universityService.findById()
//        return mapper.toUniversityMajorDepartment(dto);
//    }


//    @Named("uidtou")
//    public  University uidtou(int uid){
//        return universityService.findById(uid).get();
//    }
//}
///MAPPER için özel bir dönüşüm yazmak istersek böyle birşey yazmamız gerekiyor
//    @Mapping(source = "inch", target = "centimeter", qualifiedByName = "inchToCentimeter")
//    public UserBodyValues userBodyValuesMapper(UserBodyImperialValuesDTO dto);
//
//    @Named("inchToCentimeter")
//    public static double inchToCentimeter(int inch) {
//        return inch * 2.54;
//    }