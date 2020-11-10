package resourceserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resourceserver.exception.EntityNotFoundException;
import resourceserver.model.university.UniversityLectureContent;
import resourceserver.repository.UniversityLectureContentRepository;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UniversityLectureContentService {
    private final UniversityLectureContentRepository Repository;

    public UniversityLectureContent findById(int id) {
        Optional<UniversityLectureContent> content = Repository.findById(id);
        if (content.isEmpty()){
            throw new EntityNotFoundException(UniversityLectureContent.class, "id", Integer.toString(id));
        }
        return content.get();
    }
//
//    public List<UniversityLectureContent> findAll() {
//        return Repository.findAll();
//    }
//    public UniversityLectureContent save(UniversityLectureContent stock) {
//        return Repository.save(stock);
//    }
//
//    public void deleteById(int id) {
//        Repository.deleteById(id);
//    }
}
