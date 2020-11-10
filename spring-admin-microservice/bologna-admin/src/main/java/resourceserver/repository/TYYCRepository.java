package resourceserver.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import resourceserver.model.university.TYYC;

public interface TYYCRepository extends JpaRepository<TYYC, Integer> {
}
