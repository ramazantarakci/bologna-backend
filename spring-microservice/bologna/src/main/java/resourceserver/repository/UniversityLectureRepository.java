package resourceserver.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import resourceserver.model.university.UniversityLecture;
import resourceserver.model.university.UniversitySemester;

import java.util.List;

public interface UniversityLectureRepository extends JpaRepository<UniversityLecture, Integer> {
    List<UniversityLecture> findAllByUniversitySemester(UniversitySemester universitySemester);
}
