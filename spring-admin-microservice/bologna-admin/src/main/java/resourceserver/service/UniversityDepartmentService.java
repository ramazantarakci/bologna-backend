package resourceserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resourceserver.model.embedable.Department_about;
import resourceserver.model.university.ProgramThroughputs;
import resourceserver.model.university.TYYC;
import resourceserver.model.university.TyycPcRelation;
import resourceserver.model.university.UniversityDepartment;
import resourceserver.repository.UniversityDepartmentRepository;
import resourceserver.repository.UniversityMajorDepartmentRepository;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UniversityDepartmentService {

    private final UniversityMajorDepartmentRepository umdr;
    private final UniversityDepartmentRepository udr;

    public Optional<UniversityDepartment> findById(int id) {
        return udr.findById(id);
    }
//
//    public List<UniversityDepartment> findAllByUniversityMajorDepartment_id(int id){
//        return udr.findAllByUniversityMajorDepartment(umdr.findById(id).get());
//    }
//
//    public List<TYYC> findTYYCsById(int id){
//        return udr.findById(id).get().getTyycList();
//    }
//
//    public List<ProgramThroughputs> findProgramThroughputsById(int id){
//        return udr.findById(id).get().getProgramThroughputs();
//    }
//
//    public Department_about findDepartmentAboutById(int id){
//        return udr.findById(id).get().getDepartment_about();
//    }
//
//    public List<TyycPcRelation> findTyycPcRelation(int id){
//        return udr.findById(id).get().getTyycPcRelations();
//    }

    public UniversityDepartment save(UniversityDepartment stock) {
        return udr.save(stock);
    }

    public void deleteById(int id) {
        udr.deleteById(id);
    }
}
