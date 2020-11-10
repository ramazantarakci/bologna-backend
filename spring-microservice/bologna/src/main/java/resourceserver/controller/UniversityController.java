package resourceserver.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import resourceserver.dto.*;
import resourceserver.mapper.*;
import resourceserver.model.embedable.Department_about;
import resourceserver.model.embedable.University_type;
import resourceserver.model.university.*;
import resourceserver.service.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/university", produces={"application/json"})
//@CrossOrigin(origins = "http://localhost:8008/")
public class UniversityController {

    private final UniversityService universityService;
    private final UniversityMajorDepartmentService universityMajorDepartmentService;
    private final UniversityMapper universityMapper;
    private final UniversityMajorDepartmentMapper universityMajorDepartmentMapper;
    private final UniversityDepartmentService universityDepartmentService;
    private final UniversityDepartmentMapper universityDepartmentMapper;
    private final UniversitySemesterService universitySemesterService;
    private final UniversitySemesterMapper universitySemesterMapper;
    private final UniversityLectureContentService universityLectureContentService;
    private final TYYCService tyycService;
    private final ProgramThroughputsService programThroughputsService;
    private final LectureLearningOutcomesService outcomesService;
//    private final TyycPcMapper tyycPcMapper;

    @GetMapping("/all")
    public List<EntityModel<UniversityDTO>> findAll(){
        List<EntityModel<UniversityDTO>> universities = StreamSupport.stream(universityMapper.toUniversityDTOs(universityService.findAll()).spliterator(),false)
                .map(university -> new EntityModel<UniversityDTO>(university,
                        linkTo(methodOn(UniversityController.class).findAllMajorDepartmentsByUniversityId(university.getUniversity_id())).withSelfRel()
//                        ,linkTo(methodOn(UniversityController.class).findAll()).withRel("all")
                )).collect(Collectors.toList());
        return universities;
    }

    @GetMapping("type/{type}")//ANASAYFA yüksekokullar fakülteler enstitüler
    public List<EntityModel<UniversityDTO>> findByType(@PathVariable University_type type) {
        List<EntityModel<UniversityDTO>> universities = StreamSupport.stream(universityMapper.toUniversityDTOs(universityService.findAllByType(type)).spliterator(),false)
                .map(university -> new EntityModel<UniversityDTO>(university,
                        linkTo(methodOn(UniversityController.class).findAllMajorDepartmentsByUniversityId(university.getUniversity_id())).withSelfRel()
//                        ,linkTo(methodOn(UniversityController.class).findAll()).withRel("all")
                )).collect(Collectors.toList());
        return universities;
    }

    @GetMapping("/{id}/majordepartments")
    public List<EntityModel<UniversityMajorDepartmentDTO>> findAllMajorDepartmentsByUniversityId(@PathVariable int id){
//        List<EntityModel<UniversityMajorDepartmentDTO>> list = StreamSupport.stream(universityMajorDepartmentMapper.toUniversityMajorDepartmentDTOs(universityMajorDepartmentService.findAllByUniversity_id(id)).spliterator(),false)
//                .map(majorDepartment -> new EntityModel<UniversityMajorDepartmentDTO>(majorDepartment,
//                        linkTo(methodOn(UniversityController.class).getDepartments(majorDepartment.getMajor_department_id())).withSelfRel()
//    //                        ,linkTo(methodOn(UniversityController.class).findAll()).withRel("all")
//                )).collect(Collectors.toList());
//        return list;
        List<UniversityMajorDepartmentDTO> list = universityMajorDepartmentMapper.toUniversityMajorDepartmentDTOs(universityMajorDepartmentService.findAllByUniversity_id(id));
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setUniversity_type(list.get(i).getUniversity().getType().getUniversity_type());
        }
        return StreamSupport.stream(list.spliterator(),false).map(majorDepartment -> new EntityModel<UniversityMajorDepartmentDTO>(majorDepartment,
                        linkTo(methodOn(UniversityController.class).getDepartments(majorDepartment.getMajor_department_id())).withSelfRel()
        )).collect(Collectors.toList());
}


    @GetMapping("/majordepartment/{id}/departments")
    public List<UniversityDepartmentDTO> getDepartments(@PathVariable int id){
        List<UniversityDepartmentDTO> list = universityDepartmentMapper.toUniversityDepartmentDTOs(universityDepartmentService.findAllByUniversityMajorDepartment_id(id));
        int departmentid;
        for (UniversityDepartmentDTO universityDepartmentDTO : list) {
            departmentid = universityDepartmentDTO.getDepartment_id();
            universityDepartmentDTO.add(linkTo(methodOn(UniversityController.class).getDepartment(departmentid)).withSelfRel());
//            universityDepartmentDTO.add(linkTo(methodOn(UniversityController.class).getDepartmentProgramThroughputs(departmentid)).withRel("ProgramThroughputs"));
//            universityDepartmentDTO.add(linkTo(methodOn(UniversityController.class).getSemesters(departmentid)).withRel("Courses"));
//            universityDepartmentDTO.add(linkTo(methodOn(UniversityController.class).getTYYCs(departmentid)).withRel("TYYC"));
//            universityDepartmentDTO.add(linkTo(methodOn(UniversityController.class).getTyycPcRelation(departmentid)).withRel("TyycPcRelations"));
        }
        return list;
    }
    @GetMapping("/department/{id}")
    public UniversityDepartmentDTO getDepartment(@PathVariable int id){
        UniversityDepartmentDTO dto = universityDepartmentMapper.toUniversityDepartmentDTO(universityDepartmentService.findById(id).get());
        int departmentid;
        departmentid = dto.getDepartment_id();
        dto.add(linkTo(methodOn(UniversityController.class).getDepartmentProgramThroughputs(departmentid)).withRel("ProgramThroughputs"));
        dto.add(linkTo(methodOn(UniversityController.class).getDepartmentAbout(departmentid)).withRel("About"));
        dto.add(linkTo(methodOn(UniversityController.class).getSemesters(departmentid)).withRel("Courses"));
        dto.add(linkTo(methodOn(UniversityController.class).getTYYCs(departmentid)).withRel("TYYC"));
        dto.add(linkTo(methodOn(UniversityController.class).getTyycPcRelation(departmentid)).withRel("TyycPcRelations"));
        return dto;
    }

    ///deparmanların içeriklerine dair fonksiyonlar eklenecek
    @GetMapping("department/{id}/tyycpc")
    public List<TyycPcRelation> getTyycPcRelation(@PathVariable int id){
//        List<TyycPcRelationDTO> list = tyycPcMapper.toTyycPcRelationDTOs(universityDepartmentService.findTyycPcRelation(id));
        List<TyycPcRelation> list =universityDepartmentService.findTyycPcRelation(id);
        for (TyycPcRelation tyycPcRelation : list) {
            tyycPcRelation.add(linkTo(methodOn(UniversityController.class).getTYYCById(tyycPcRelation.getTyyc_id())).withRel("TYYC"));
            tyycPcRelation.add(linkTo(methodOn(UniversityController.class).getProgramThroughputById(tyycPcRelation.getThroughput_id())).withRel("PC"));
        }
        return list;
    }
    @GetMapping("pt/{id}")
    public ProgramThroughputs getProgramThroughputById(@PathVariable int id){
        return programThroughputsService.findById(id).get();
    }
    @GetMapping("llo/{id}")
    public LectureLearningOutcomes getLectureLearningOutcomes(@PathVariable int id){
        return outcomesService.findById(id).get();
    }

    @GetMapping("tyyc/{id}")
    public TYYC getTYYCById(@PathVariable int id){
        return tyycService.findById(id).get();
    }

    ///deparmanların içeriklerine dair fonksiyonlar eklenecek
    @GetMapping("department/{id}/about")
    public Department_about getDepartmentAbout(@PathVariable int id){
        return universityDepartmentService.findDepartmentAboutById(id);
    }

    @GetMapping("department/{id}/pt")
    public List<ProgramThroughputs> getDepartmentProgramThroughputs(@PathVariable int id){//
//        ProgramThroughputsDTO dto = universityDepartmentMapper.toProgramThroughputsDTO(universityDepartmentService.findById(id).get());
//        return ResponseEntity.ok(dto);
//        return universityDepartmentService.findProgramThroughputsById(id);///SERVİCE KISMINDA GETLE ALIP BASIYORUM GELMİYOR
        return universityDepartmentService.findProgramThroughputsById(id);
    }

    @GetMapping("department/{id}/tyyc")
    public List<TYYC> getTYYCs(@PathVariable int id){
        return universityDepartmentService.findTYYCsById(id);
    }

    @GetMapping("department/{id}/courses")
    public List<UniversitySemesterDTO> getSemesters(@PathVariable int id){
        List<UniversitySemesterDTO> list = universitySemesterMapper.toUniversitySemesterDTOs(universitySemesterService.findByUniversityDepartment(id));
        for (UniversitySemesterDTO universitySemesterDTO : list) {
            for (int j = 0; j < universitySemesterDTO.getUniversityLectures().size(); j++) {
                universitySemesterDTO.getUniversityLectures().get(j).add(linkTo(methodOn(UniversityController.class).getUniversityLectureContent(universitySemesterDTO.getUniversityLectures().get(j).getLecture_id())).withSelfRel());
            }
        }///LAMBDA EXPRESSİONLA YAPILABİLİR AMA BEN YAPAMADIM 6 saat uğraştım.
        return list;
    }
//    @GetMapping("department/{id}/relation")
//    public List<Integer>
//
    @GetMapping("course/{id}/content")
    public UniversityLectureContent getUniversityLectureContent(@PathVariable int id){
        return universityLectureContentService.findById(id);
    }

//    @GetMapping("getsingle/{id}")
//    public University getSingleUniversity(@PathVariable int id){
//        return universityService.findById(id);
//    }
}


///NESTED MAP LAMBDA DENEME 1
//    @GetMapping("department/{id}/courses")
//    public List<EntityModel<UniversitySemesterDTO>> getSemesters(@PathVariable int id){
//        List<EntityModel<UniversitySemesterDTO>> list = StreamSupport.stream(universitySemesterMapper.toUniversitySemesterDTOs(universitySemesterService.findByUniversityDepartment(id)).spliterator(),false)
//                .map( semester -> StreamSupport.stream(semester.getUniversityLectures().spliterator(),false).map(lecture -> {
//                    new EntityModel<UniversityLectureDTO>(lecture,
//                            linkTo(methodOn(UniversityController.class).getSemesters(id)).withSelfRel());
//                }).collect(Collectors.toList()))
//                .collect(Collectors.toList());
//        return list;
//    }






//    @GetMapping///İHTİYAÇ OLURSA AÇILACAK
//    public ResponseEntity<ScratchResponse> apiguide(){
//        ScratchResponse guide = new ScratchResponse();
//        Link link = linkTo(methodOn(UniversityController.class).findAll()).withRel("TÜM BİRİMLER");
//        Link link2  = linkTo(methodOn(UniversityController.class).findByType(University_type.Enstitü)).withRel("Enstitüler");
//        Link link3 = linkTo(methodOn(UniversityController.class).findByType(University_type.Fakülte)).withRel("Fakülteler");
//        Link link4 = linkTo(methodOn(UniversityController.class).findByType(University_type.YüksekOkul)).withRel("YüksekOkullar");
//        return ResponseEntity.ok(guide.add(link).add(link2).add(link3).add(link4));
//    }


//    private final UniversityMajorDepartmentService universityMajorDepartmentService;
//    @GetMapping("/all")
//    ResponseEntity<CollectionModel<EntityModel<UniversityDTO>>> findAll(){
//        List<EntityModel<UniversityDTO>> universities = StreamSupport.stream(universityMapper.toUniversityDTOs(universityService.findAll()).spliterator(),false)
//                .map(university -> new EntityModel<UniversityDTO>(university,
//                        linkTo(methodOn(UniversityController.class).findById(university.getUniversity_id())).withSelfRel(),
//                        linkTo(methodOn(UniversityController.class).findAll()).withRel("all")))
//                        .collect(Collectors.toList());
//        return ResponseEntity.ok(new CollectionModel<>(universities, linkTo(methodOn(UniversityController.class).findAll()).withSelfRel()));

//    }


//    @GetMapping("/all")//ANASAYFA TÜM BİRİMLER
//    public ResponseEntity<List<UniversityDTO>> findAll() {
//        return ResponseEntity.ok(universityMapper.toUniversityDTOs(universityService.findAll()));
//    }

///////////////////////////////////////////////
//    @GetMapping("/{id}/majordepartments")
//    public ResponseEntity<List<UniversityMajorDepartmentDTO>> findAllMajorDepartmentsByUniversityId(@PathVariable int id){
//        UniversityMDDTO item = universityMapper.toUniversityMDDTO(universityService.findById(id).get());
//        List<UniversityMajorDepartmentDTO> dto = universityMajorDepartmentMapper.toUniversityMajorDepartmentDTOs(item.getUniversity_majorDepartments());
//        return ResponseEntity.ok(dto);
//    }
///////////////////////////////////////////////

//    @GetMapping("/majordepartments")
//    public Collection<EntityModel<UniversityMajorDepartmentDTO>> findAllMajorDepartments(){
//    List<EntityModel<UniversityMajorDepartmentDTO>> majorDepartments = StreamSupport.stream(universityMajorDepartmentMapper.toUniversityMajorDepartmentDTOs(universityMajorDepartmentService.findAll()).spliterator(),false)
//            .map(majorDepartment -> new EntityModel<UniversityMajorDepartmentDTO>(majorDepartment,
//                    linkTo(methodOn(UniversityController.class).findMajorDepartment(majorDepartment.getMajor_department_id())).withSelfRel()
////                        ,linkTo(methodOn(UniversityController.class).findAll()).withRel("all")
//            )).collect(Collectors.toList());
////        return ResponseEntity.ok();
//        return majorDepartments;
//    }

//    @GetMapping("/details/{id}")//idye göre birim içeriği
//    public ResponseEntity<UniversityDTO> findById(@PathVariable int id) {
//        Optional<University> university = universityService.findById(id);
//        return ResponseEntity.ok(universityMapper.toUniversityDTO(university.get()));

//    }
//    @GetMapping("/details/{id}")//idye göre birim içeriği SON ORJİNAL
//    public ResponseEntity<UniversityDTO> findById(@PathVariable int id) {
//        Optional<University> university = universityService.findById(id);
//        Link link = linkTo(methodOn(UniversityController.class)
//                .findById(id))
////                  .withRel("university");
//                    .withSelfRel();
//        return ResponseEntity.ok(universityMapper.toUniversityDTO(university.get()).add(link));
//    }
//    @GetMapping("/details/{id}")//idye göre birim içeriği
//    public List<UniversityMajorDepartment> findallasdf(@PathVariable int id){
//        List<UniversityMajorDepartment> list = universityMajorDepartmentService.findAllByUniversity(id);
//        return list;
//    }
//    @GetMapping("/details/{id}")
//    public ResponseEntity<University> findById(@PathVariable int id) {
//        Optional<University> university = universityService.findById(id);
//        Link link = linkTo(methodOn(UniversityController.class)
//                .findAll())
//                      .withRel("universities");
////                .withSelfRel();
//        return ResponseEntity.ok(university.get().add(link));
//    }



//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Data;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import resourceserver.model.university.University;
//import resourceserver.model.university.UniversityMajorDepartment;
//import resourceserver.repository.University_repositoryImpl;
//
//import java.util.List;
//
//@Data
//@RestController
//@RequestMapping(value = "/university")
//public class UniversityController {
//
//    private University_repositoryImpl repository = new University_repositoryImpl();
//
//    @GetMapping("/all")
//    public List<University> selectAll(){
//        return repository.findAll();
//    }
//
//    @GetMapping("/{id}/majordepartments")
//    public List<UniversityMajorDepartment> getdeps(@PathVariable Integer id) throws Exception{
//        List<UniversityMajorDepartment> university = repository.getUniversity_majorDepartments(id);
//        return university;
//    }
//
//    @GetMapping("/{id}")
//    public University getitem(@PathVariable Integer id) throws Exception{
//        return repository.findById(id);
//    }
//
//}
