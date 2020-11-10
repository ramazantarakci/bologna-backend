package resourceserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resourceserver.model.university.TyycPcRelation;
import resourceserver.repository.TyycPcRelationRepository;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TyycPcRelationService {
    private final TyycPcRelationRepository repository;
    public List<TyycPcRelation> findAll() {
        return repository.findAll();
    }

    public Optional<TyycPcRelation> findById(int id) {
        return repository.findById(id);
    }
//
//    public TyycPcRelation save(TyycPcRelation stock) {
//        return repository.save(stock);
//    }
//
//    public void deleteById(int id) {
//        repository.deleteById(id);
//    }
}
