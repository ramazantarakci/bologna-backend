package resourceserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resourceserver.exception.EntityNotFoundException;
import resourceserver.model.embedable.Department_about;
import resourceserver.model.university.*;
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

    public List<UniversityDepartment> findAllByUniversityMajorDepartment_id(int id){
        Optional<UniversityMajorDepartment> majorDepartment = umdr.findById(id);
        if (majorDepartment.isEmpty()){
            throw new EntityNotFoundException(UniversityMajorDepartment.class, "id", Integer.toString(id));
        }
        List<UniversityDepartment> list= udr.findAllByUniversityMajorDepartment(majorDepartment.get());
        if (list.isEmpty()){
            throw new EntityNotFoundException(UniversityDepartment.class, "UniversityMajorDepartment", Integer.toString(id));
        }
        return list;
    }

    public List<TYYC> findTYYCsById(int id){
        Optional<UniversityDepartment> department = udr.findById(id);
        if (department.isEmpty()){
            throw new EntityNotFoundException(UniversityDepartment.class,"id",Integer.toString(id));
        }////////////////BURADA LİSTE DOLO DEĞİLSE NULL DEĞERİ DE  DÖNDÜRÜLEBİLİR İSEMPTY KONTROLÜ İLE
        return department.get().getTyycList();
    }

    public List<ProgramThroughputs> findProgramThroughputsById(int id){
        Optional<UniversityDepartment> department = udr.findById(id);
        if (department.isEmpty()){
            throw new EntityNotFoundException(UniversityDepartment.class,"id",Integer.toString(id));
        }////////////////BURADA LİSTE DOLO DEĞİLSE NULL DEĞERİ DE  DÖNDÜRÜLEBİLİR İSEMPTY KONTROLÜ İLE
        return department.get().getProgramThroughputs();
    }

    public Department_about findDepartmentAboutById(int id){
        Optional<UniversityDepartment> department = udr.findById(id);
        if (department.isEmpty()){
            throw new EntityNotFoundException(UniversityDepartment.class,"id",Integer.toString(id));
        }////////////////BURADA LİSTE DOLO DEĞİLSE NULL DEĞERİ DE  DÖNDÜRÜLEBİLİR İSEMPTY KONTROLÜ İLE
        return department.get().getDepartment_about();
    }

    public List<TyycPcRelation> findTyycPcRelation(int id){
        Optional<UniversityDepartment> department = udr.findById(id);
        if (department.isEmpty()){
            throw new EntityNotFoundException(UniversityDepartment.class,"id",Integer.toString(id));
        }////////////////BURADA LİSTE DOLO DEĞİLSE NULL DEĞERİ DE  DÖNDÜRÜLEBİLİR İSEMPTY KONTROLÜ İLE
        return department.get().getTyycPcRelations();
    }
//
//    public UniversityDepartment save(UniversityDepartment stock) {
//        return udr.save(stock);
//    }
//
//    public void deleteById(int id) {
//        udr.deleteById(id);
//    }
}
