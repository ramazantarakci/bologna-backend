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
public class MajorDepartmentController {
    private final UniversityMajorDepartmentService universityMajorDepartmentService;
    private final UniversityMajorDepartmentMapper universityMajorDepartmentMapper;
    private final UniversityService universityService;
//    private final UniversityMapper universityMapper;
//    private final UniversityDepartmentService universityDepartmentService;
//    private final UniversityDepartmentMapper universityDepartmentMapper;
//    private final UniversitySemesterService universitySemesterService;
//    private final UniversitySemesterMapper universitySemesterMapper;
//    private final UniversityLectureContentService universityLectureContentService;
//    private final TYYCService tyycService;
//    private final ProgramThroughputsService programThroughputsService;
//    private final LectureLearningOutcomesService outcomesService;

    @PostMapping("/major-department")
    public ResponseEntity saveUniversity(@RequestBody UniversityMajorDepartmentDTO dto) {////@Valid Ne işe yarıyor ?
//        universityMajorDepartmentService.save(universityMajorDepartmentMapper.toUniversityMajorDepartment(dto));
//        dto.setUniversity(universityService.findById(dto.ge));
        dto.setUniversity(universityService.findById(dto.getUniversity_id()).get());
        return ResponseEntity.ok(universityMajorDepartmentService.save(universityMajorDepartmentMapper.toUniversityMajorDepartment(dto)));
//        return ResponseEntity.ok(universityMajorDepartmentService.save(universityMajorDepartmentMapper.toUniversityMajorDepartment(dto)));
    }
    @PutMapping("/major-department")
    public ResponseEntity updateallUniversity(@RequestBody UniversityMajorDepartmentDTO dto){
        return ResponseEntity.ok(universityMajorDepartmentService.save(universityMajorDepartmentMapper.toUniversityMajorDepartment(dto)));
    }
    @PatchMapping("/major-department")
    public ResponseEntity updateUniversity(@RequestBody UniversityMajorDepartmentDTO dto){
        return ResponseEntity.ok(universityMajorDepartmentService.save(universityMajorDepartmentMapper.toUniversityMajorDepartment(dto)));
    }
    @DeleteMapping("/major-department/{id}")
    public ResponseEntity deleteUniversity(@PathVariable int id) {
        universityMajorDepartmentService.deleteById(id);
        return ResponseEntity.ok().body(null);///EĞER GEREKİRSE RESPONSEBODY İÇERİĞİ BURADA AYARLANABİLİR ŞUAN NULL
    }
}