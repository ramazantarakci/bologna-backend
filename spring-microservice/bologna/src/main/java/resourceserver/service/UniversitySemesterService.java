package resourceserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resourceserver.exception.EntityNotFoundException;
import resourceserver.model.university.University;
import resourceserver.model.university.UniversityDepartment;
import resourceserver.model.university.UniversitySemester;
import resourceserver.repository.UniversityDepartmentRepository;
import resourceserver.repository.UniversitySemesterRepository;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UniversitySemesterService {
    private final UniversityDepartmentRepository universityDepartmentRepository;
    private final UniversitySemesterRepository Repository;

//    public List<UniversitySemester> findAll() {
//        return Repository.findAll();
//    }

//    public Optional<UniversitySemester> findById(int id) {
//        Optional<UniversitySemester> universitySemester = Repository.findById(id);
//        if (universitySemester.isEmpty()) {
//            throw new EntityNotFoundException(UniversitySemester.class, "id",Integer.toString(id));
//        }
//        return universitySemester;
//    }

    public List<UniversitySemester> findByUniversityDepartment(int id){
        Optional<UniversityDepartment> department =universityDepartmentRepository.findById(id);
        if (department.isEmpty()){
            throw new EntityNotFoundException(UniversityDepartment.class,"id",Integer.toString(id));
        }
        List<UniversitySemester> list = Repository.findAllByUniversityDepartment(department.get());
        if (list.isEmpty()){
            throw new EntityNotFoundException(UniversitySemester.class,"departmentid",Integer.toString(id));
        }
        return list;
    }
//
//    public UniversitySemester save(UniversitySemester stock) {
//        return Repository.save(stock);
//    }
//
//    public void deleteById(int id) {
//        Repository.deleteById(id);
//    }
}
