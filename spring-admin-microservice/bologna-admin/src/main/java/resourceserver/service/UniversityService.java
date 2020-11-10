package resourceserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resourceserver.exception.EntityNotFoundException;
import resourceserver.model.embedable.University_type;
import resourceserver.model.university.University;
import resourceserver.repository.UniversityRepository;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UniversityService {
//  @Autowired GEREKLİ Mİ @RequiredArgsConstructor yeterli mi araştırılmalı ?
    private final UniversityRepository universityRepository;

    public List<University> findAll() {
        return universityRepository.findAll();
    }

    public Optional<University> findById(int id) {
        return universityRepository.findById(id);
    }

    public List<University> findAllByType(University_type type){
        return universityRepository.findAllByType(type);
    }
//
    public University save(University university) {
//        if (university.getName().isBlank()){
//            throw new EntityNotFoundException(University.class);
//        }
//        try {
//            universityRepository.save(university);
//        }catch (Exception e){
//            throw new EntityNotFoundException(University.class);
//        }
//        return university;
        return universityRepository.save(university);
    }

    public void deleteById(int id) {
        if (findById(id).isEmpty()){
            throw new EntityNotFoundException(University.class,"id",Integer.toString(id));
        }
        universityRepository.deleteById(id);
    }
}
