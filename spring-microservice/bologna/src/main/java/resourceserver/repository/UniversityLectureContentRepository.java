package resourceserver.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import resourceserver.model.university.UniversityLectureContent;

public interface UniversityLectureContentRepository extends JpaRepository<UniversityLectureContent, Integer> {
}
