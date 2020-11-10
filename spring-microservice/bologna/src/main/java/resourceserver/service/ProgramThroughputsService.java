package resourceserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resourceserver.exception.EntityNotFoundException;
import resourceserver.model.university.ProgramThroughputs;
import resourceserver.repository.ProgramThroughputsRepository;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProgramThroughputsService {
    private final ProgramThroughputsRepository repository;
//    public List<ProgramThroughputs> findAll() {
//        return repository.findAll();
//    }

    public Optional<ProgramThroughputs> findById(int id) {
        Optional<ProgramThroughputs> programThroughputs = repository.findById(id);
        if(programThroughputs.isEmpty()){
            throw new EntityNotFoundException(ProgramThroughputs.class,"id",Integer.toString(id));
        }
        return programThroughputs;
    }
//
//    public ProgramThroughputs save(ProgramThroughputs stock) {
//        return repository.save(stock);
//    }
//
//    public void deleteById(int id) {
//        repository.deleteById(id);
//    }
}
