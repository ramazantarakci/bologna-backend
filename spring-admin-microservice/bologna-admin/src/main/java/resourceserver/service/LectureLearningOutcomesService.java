package resourceserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import resourceserver.model.university.LectureLearningOutcomes;
import resourceserver.repository.LectureLearningOutcomesRepository;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LectureLearningOutcomesService {
    private final LectureLearningOutcomesRepository repository;

    public List<LectureLearningOutcomes> findAll() {
        return repository.findAll();
    }

    public Optional<LectureLearningOutcomes> findById(int id) {
        return repository.findById(id);
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