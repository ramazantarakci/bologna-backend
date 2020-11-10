package resourceserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resourceserver.exception.EntityNotFoundException;
import resourceserver.model.blog.PageContent;
import resourceserver.repository.PageContentRepository;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PageContentService {
    private final PageContentRepository Repository;
//    public List<PageContent> findAll() {
//        return Repository.findAll();
//    }

    public Optional<PageContent> findById(int id) {
        Optional<PageContent> pageContent = Repository.findById(id);
        if (pageContent.isEmpty()){
            throw new EntityNotFoundException(PageContent.class, "id", Integer.toString(id));
        }
        return pageContent;
    }
//
//    public PageContent save(PageContent stock) {
//        return Repository.save(stock);
//    }
//
//    public void deleteById(int id) {
//        Repository.deleteById(id);
//    }
}
