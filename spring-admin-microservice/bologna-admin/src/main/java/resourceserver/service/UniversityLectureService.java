package resourceserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resourceserver.model.university.UniversityLecture;
import resourceserver.repository.UniversityLectureRepository;
import resourceserver.repository.UniversitySemesterRepository;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UniversityLectureService {
    private final UniversityLectureRepository Repository;
    private final UniversitySemesterRepository universitySemesterRepository;
    public List<UniversityLecture> findAll() {
        return Repository.findAll();
    }

    public Optional<UniversityLecture> findById(int id) {
        return Repository.findById(id);
    }
//
//    public UniversityLecture save(UniversityLecture stock) {
//        return Repository.save(stock);
//    }

//    public void deleteById(int id) {
//        Repository.deleteById(id);
//    }
//
//    public List<UniversityLecture> findAllByUniversitySemesterid(int id){
//        return Repository.findAllByUniversitySemester(universitySemesterRepository.findById(id).get());
//    }//////TAMAMLA JSONU DÜZELT YADA GEREK KALMAMIŞ BU FONKSİYONA
}
