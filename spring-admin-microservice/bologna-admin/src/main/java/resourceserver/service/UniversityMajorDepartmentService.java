package resourceserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resourceserver.model.university.UniversityMajorDepartment;
import resourceserver.repository.UniversityMajorDepartmentRepository;
import resourceserver.repository.UniversityRepository;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UniversityMajorDepartmentService {
    private final UniversityMajorDepartmentRepository repository;
    private final UniversityRepository universityRepository;

//    public List<UniversityMajorDepartment> findAll() {
//        return repository.findAll();
//    }
//
    public Optional<UniversityMajorDepartment> findById(int id) {
        return repository.findById(id);
    }

//    public List<UniversityMajorDepartment> findAllByUniversity_id(int id) {
//        return repository.findAllByUniversity(universityRepository.findById(id).get());
//        return repository.findUniversityMajorDepartmentsByUniversity_University_id(id);
//    }

    public UniversityMajorDepartment save(UniversityMajorDepartment majorDepartment) {
        return repository.save(majorDepartment);
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}