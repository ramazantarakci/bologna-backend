package resourceserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resourceserver.exception.EntityNotFoundException;
import resourceserver.model.university.University;
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

    public List<UniversityMajorDepartment> findAllByUniversity_id(int id) {
        Optional<University> university = universityRepository.findById(id);
        if (university.isEmpty()) {
            throw new EntityNotFoundException(University.class, "id",Integer.toString(id));
        }
        List<UniversityMajorDepartment> list = repository.findAllByUniversity(university.get());
        if(list.isEmpty()){
            throw new EntityNotFoundException(UniversityMajorDepartment.class,"universityid",Integer.toString(id));
        }
        return list;
    }

//    public List<UniversityMajorDepartment> findAll() {///GEREKSİZ OLDUĞUNU GÖRDÜM TESTTEN SONRA SİLİNECEK
//        return repository.findAll();

//    }
//    public Optional<UniversityMajorDepartment> findById(int id) {///GEREKSİZ OLDUĞUNU GÖRDÜM TESTTEN SONRA SİLİNECEK
//        return repository.findById(id);

//    }
//    public UniversityMajorDepartment save(UniversityMajorDepartment majorDepartment) {
//        return repository.save(majorDepartment);
//    }
//    public void deleteById(int id) {
//        repository.deleteById(id);
//    }
}