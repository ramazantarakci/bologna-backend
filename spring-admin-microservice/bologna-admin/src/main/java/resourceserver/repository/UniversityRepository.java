package resourceserver.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import resourceserver.model.embedable.University_type;
import resourceserver.model.university.University;
import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Integer> {
    List<University> findAllByType(University_type type);
}
