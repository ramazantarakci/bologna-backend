package resourceserver.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import resourceserver.dto.*;
import resourceserver.dto.subdto.UpdatePT;
import resourceserver.mapper.*;
import resourceserver.service.*;

import javax.annotation.security.RolesAllowed;
import java.util.Objects;

//@RolesAllowed("user")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/admin")
public class ProgramThroughputsController {
    private final UniversityDepartmentService universityDepartmentService;
    private final UniversityDepartmentMapper universityDepartmentMapper;
    private final ProgramThroughputsService programThroughputsService;

    @GetMapping("/university/{id}/pts")
    public ResponseEntity getProgramThroughputsByUniversityid(@PathVariable int id) {////@Valid Ne işe yarıyor ?
        return ResponseEntity.ok(universityDepartmentService.findById(id).get().getProgramThroughputs());
    }

    @GetMapping("/pt/{id}")
    public ResponseEntity getProgramThroughput(@PathVariable int id) {////@Valid Ne işe yarıyor ?
        return ResponseEntity.ok(programThroughputsService.findById(id).get());
    }

    @PostMapping("/pts")
    public ResponseEntity saveProgramThroughputs(@RequestBody ProgramThroughputsDTO dto) {////@Valid Ne işe yarıyor ?
        dto.setUniversityDepartment(universityDepartmentService.findById(dto.getDepartment_id()).get());
        int count = universityDepartmentService.findById(dto.getDepartment_id()).get().getProgramThroughputs().size();
        for (int i = 0; i <dto.getPtList().size(); i++) {
            dto.getPtList().get(i).setThroughput_id("P.Ç. "+Integer.toString(count+i+1));
            dto.getPtList().get(i).setUniversityDepartment(dto.getUniversityDepartment());
            programThroughputsService.save(universityDepartmentMapper.toProgramThroughputs(dto.getPtList().get(i)));
        }
        return ResponseEntity.ok(Objects.requireNonNull(getProgramThroughputsByUniversityid(dto.getDepartment_id()).getBody()));
    }

    @PostMapping("/pt")
    public ResponseEntity addProgramThroughput(@RequestBody UpdatePT dto){
        dto.setUniversityDepartment(universityDepartmentService.findById(dto.getDepartment_id()).get());
        int id = programThroughputsService.save(universityDepartmentMapper.toProgramThroughputs(dto)).getId();
        return ResponseEntity.ok(Objects.requireNonNull(getProgramThroughput(id).getBody()));
    }

    @PutMapping("/pt")
    public ResponseEntity editProgramThroughput(@RequestBody UpdatePT dto){
        dto.setUniversityDepartment(universityDepartmentService.findById(dto.getDepartment_id()).get());
        int id = programThroughputsService.save(universityDepartmentMapper.toProgramThroughputs(dto)).getId();
        return ResponseEntity.ok(Objects.requireNonNull(getProgramThroughput(id).getBody()));
    }

    @DeleteMapping("/pt/{id}")
    public ResponseEntity deleteProgramThroughputs(@PathVariable int id) {
        programThroughputsService.deleteById(id);
        return ResponseEntity.ok().body(null);///EĞER GEREKİRSE RESPONSEBODY İÇERİĞİ BURADA AYARLANABİLİR ŞUAN NULL
    }
}
