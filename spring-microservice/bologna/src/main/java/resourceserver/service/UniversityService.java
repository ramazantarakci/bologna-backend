package resourceserver.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resourceserver.model.embedable.University_type;
import resourceserver.model.university.University;
import resourceserver.repository.UniversityRepository;
import resourceserver.exception.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UniversityService {
    private final UniversityRepository universityRepository;

    public List<University> findAll() {
        List<University> list = universityRepository.findAll();
        if (list.isEmpty()){
            throw new EntityNotFoundException(University.class,"all","all");
        }
        return list;
    }

    public University findById(int id){
        Optional<University> university = universityRepository.findById(id);
        if (university.isEmpty()) {
            throw new EntityNotFoundException(University.class, "id",Integer.toString(id));
        }
        return university.get();
    }

    public List<University> findAllByType(University_type type){
        List<University> list = universityRepository.findAllByType(type);
        if (list.isEmpty()){
            throw new EntityNotFoundException(University.class,"type",type.getUniversity_type());
        }
        return list;
    }
//
//    public University save(University stock) {
//        return universityRepository.save(stock);
//    }
//
//    public void deleteById(int id) {
//        universityRepository.deleteById(id);
//    }
}
