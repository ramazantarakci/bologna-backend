package resourceserver.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import resourceserver.model.university.ProgramThroughputs;

public interface ProgramThroughputsRepository extends JpaRepository<ProgramThroughputs, Integer> {
}
