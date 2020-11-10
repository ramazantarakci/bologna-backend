package resourceserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.hql.internal.ast.tree.UnaryArithmeticNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import resourceserver.apierror.ApiValidationError;
import resourceserver.dto.*;
import resourceserver.mapper.*;
import resourceserver.model.embedable.University_type;
import resourceserver.model.university.*;
import resourceserver.service.*;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/admin")
public class UniversityController {
    private final UniversityService universityService;
    private final UniversityMapper universityMapper;
//    private final UniversityMajorDepartmentService universityMajorDepartmentService;
    private final UniversityMajorDepartmentMapper universityMajorDepartmentMapper;
//    private final UniversityDepartmentService universityDepartmentService;
//    private final UniversityDepartmentMapper universityDepartmentMapper;
//    private final UniversitySemesterService universitySemesterService;
//    private final UniversitySemesterMapper universitySemesterMapper;
//    private final UniversityLectureContentService universityLectureContentService;
//    private final TYYCService tyycService;
//    private final ProgramThroughputsService programThroughputsService;
//    private final LectureLearningOutcomesService outcomesService;

//    @GetMapping("/university/{id}")
//    public ResponseEntity<UniversityListDTO> getUniversity(@PathVariable int id){
//        UniversityListDTO dto = universityMapper.toUniversityListDTO(universityService.findById(id).get());
//        dto.add(linkTo(methodOn(UniversityController.class).getUniversity(id)).withSelfRel());
//        return ResponseEntity.ok(dto);
//    }
    @GetMapping("/university/type/{type}")
    public ResponseEntity saveUniversity(@PathVariable University_type type) {////@Valid Ne işe yarıyor ?
        return ResponseEntity.ok(universityMapper.toUniversityNameListDTO(universityService.findAllByType(type)));
    }
    @GetMapping("/university/{id}/majordepartments")
    public ResponseEntity getMajorDepartments(@PathVariable int id) {////@Valid Ne işe yarıyor ?
        Optional<University> university = universityService.findById(id);
        return ResponseEntity.ok(universityMajorDepartmentMapper.toMajorDepartmentListDTO(university.get().getUniversity_majorDepartments()));

    }
    @PostMapping("/university")
    public ResponseEntity<University> saveUniversity(@RequestBody UniversityDTO dto) {////@Valid Ne işe yarıyor ?
        return ResponseEntity.ok(universityService.save(universityMapper.toUniversity(dto)));
    }
    @PutMapping("/university")
    public ResponseEntity updateallFieldsInUniversity(@RequestBody UniversityDTO dto){
        return ResponseEntity.ok(universityService.save(universityMapper.toUniversity(dto)));
    }
    @PatchMapping("/university")
    public ResponseEntity updateUniversity(@RequestBody UniversityDTO dto){
        return ResponseEntity.ok(universityService.save(universityMapper.toUniversity(dto)));
    }
    @DeleteMapping("/university/{id}")
    public ResponseEntity deleteUniversity(@PathVariable int id) {
        universityService.deleteById(id);
        return ResponseEntity.ok().body(null);///EĞER GEREKİRSE RESPONSEBODY İÇERİĞİ BURADA AYARLANABİLİR ŞUAN NULL
    }
}