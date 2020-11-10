package resourceserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

    public List<UniversitySemester> findAll() {
        return Repository.findAll();
    }

    public Optional<UniversitySemester> findById(int id) {
        return Repository.findById(id);
    }

    public List<UniversitySemester> findByUniversityDepartment(int id){
        return Repository.findAllByUniversityDepartment(universityDepartmentRepository.findById(id).get());
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
