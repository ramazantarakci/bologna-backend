package resourceserver.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import resourceserver.dto.*;
import resourceserver.mapper.*;
import resourceserver.service.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/admin")
public class DepartmentController {
//    private final UniversityService universityService;
//    private final UniversityMapper universityMapper;
    private final UniversityMajorDepartmentService universityMajorDepartmentService;
//    private final UniversityMajorDepartmentMapper universityMajorDepartmentMapper;
    private final UniversityDepartmentService universityDepartmentService;
    private final UniversityDepartmentMapper universityDepartmentMapper;
//    private final UniversitySemesterService universitySemesterService;
//    private final UniversitySemesterMapper universitySemesterMapper;
//    private final UniversityLectureContentService universityLectureContentService;
//    private final TYYCService tyycService;
//    private final ProgramThroughputsService programThroughputsService;
//    private final LectureLearningOutcomesService outcomesService;

    @GetMapping("/department/{id}")
    public ResponseEntity getUniversity(@PathVariable int id) {////@Valid Ne işe yarıyor ?
        return ResponseEntity.ok(universityDepartmentMapper.toUniversityDepartmentDTO(universityDepartmentService.findById(id).get()));
    }
    @PostMapping("/department")
    public ResponseEntity saveUniversity(@RequestBody UniversityDepartmentDTO dto) {////@Valid Ne işe yarıyor ?
        dto.setUniversityMajorDepartment(universityMajorDepartmentService.findById(dto.getMajor_department_id()).get());
        return ResponseEntity.ok(universityDepartmentService.save(universityDepartmentMapper.toUniversityDepartment(dto)));
    }
    @PutMapping("/department")
    public ResponseEntity updateallUniversity(@RequestBody UniversityDepartmentDTO dto){
        return ResponseEntity.ok(universityDepartmentService.save(universityDepartmentMapper.toUniversityDepartment(dto)));
    }
    @PatchMapping("/department")
    public ResponseEntity updateUniversity(@RequestBody UniversityDepartmentDTO dto){
        return ResponseEntity.ok(universityDepartmentService.save(universityDepartmentMapper.toUniversityDepartment(dto)));
    }
    @DeleteMapping("/department/{id}")
    public ResponseEntity deleteUniversity(@PathVariable int id) {
        universityDepartmentService.deleteById(id);
        return ResponseEntity.ok().body(null);///EĞER GEREKİRSE RESPONSEBODY İÇERİĞİ BURADA AYARLANABİLİR ŞUAN NULL
    }
}





