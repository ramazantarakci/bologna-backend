package resourceserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resourceserver.model.blog.Pages;
import resourceserver.repository.PagesRepository;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PagesService {
    private final PagesRepository Repository;
    public List<Pages> findAll() {
        return Repository.findAll();
    }

    public Optional<Pages> findById(int id) {
        return Repository.findById(id);
    }
//
//    public Pages save(Pages stock) {
//        return Repository.save(stock);
//    }
//
//    public void deleteById(int id) {
//        Repository.deleteById(id);
//    }
}
