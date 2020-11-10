package resourceserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resourceserver.model.university.UniversityLectureContent;
import resourceserver.repository.UniversityLectureContentRepository;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UniversityLectureContentService {
    private final UniversityLectureContentRepository Repository;

    public Optional<UniversityLectureContent> findById(int id) {
        return Repository.findById(id);
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
