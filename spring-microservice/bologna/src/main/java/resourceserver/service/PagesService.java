package resourceserver.service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import resourceserver.exception.EntityNotFoundException;
import resourceserver.model.blog.Pages;
import resourceserver.repository.PagesRepository;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PagesService {
//    @Autowired
    private final PagesRepository Repository;
    public List<Pages> findAll() {
        List<Pages> pages  =  Repository.findAll();
        if (pages.isEmpty()){
            throw new EntityNotFoundException(Pages.class, "all","all");
        }
        return pages;
    }

//    public Optional<Pages> findById(int id) {
//        return Repository.findById(id);
//    }
//
//    public Pages save(Pages stock) {
//        return Repository.save(stock);
//    }
//
//    public void deleteById(int id) {
//        Repository.deleteById(id);
//    }
}
