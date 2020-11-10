package resourceserver.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import resourceserver.model.university.LectureLearningOutcomes;

public interface LectureLearningOutcomesRepository extends JpaRepository<LectureLearningOutcomes, Integer> {
}
