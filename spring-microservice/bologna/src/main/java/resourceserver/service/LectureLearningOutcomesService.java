package resourceserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resourceserver.exception.EntityNotFoundException;
import resourceserver.model.university.LectureLearningOutcomes;
import resourceserver.repository.LectureLearningOutcomesRepository;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LectureLearningOutcomesService {
    private final LectureLearningOutcomesRepository repository;

//    public List<LectureLearningOutcomes> findAll() {
//        return repository.findAll();
//    }

    public Optional<LectureLearningOutcomes> findById(int id) {
        Optional<LectureLearningOutcomes> outcome = repository.findById(id);
        if (outcome.isEmpty()){
            throw new EntityNotFoundException(LectureLearningOutcomes.class, "id", Integer.toString(id));
        }
        return outcome;
    }
//
//    public LectureLearningOutcomes save(LectureLearningOutcomes stock) {
//        return repository.save(stock);
//    }
//
//    public void deleteById(int id) {
//        repository.deleteById(id);
//    }
}