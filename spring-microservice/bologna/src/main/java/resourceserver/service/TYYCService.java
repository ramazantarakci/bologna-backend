package resourceserver.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resourceserver.exception.EntityNotFoundException;
import resourceserver.model.university.TYYC;
import resourceserver.repository.TYYCRepository;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TYYCService {
    private final TYYCRepository repository;
//    public List<TYYC> findAll() {
//        return repository.findAll();
//    }

    public Optional<TYYC> findById(int id) {
        Optional<TYYC> tyyc = repository.findById(id);
        if (tyyc.isEmpty()){
            throw new EntityNotFoundException(TYYC.class, "id", Integer.toString(id));
        }
        return tyyc;
    }

//    public TYYC save(TYYC stock) {
//        return repository.save(stock);
//    }
//
//    public void deleteById(int id) {
//        repository.deleteById(id);
//    }
//
}