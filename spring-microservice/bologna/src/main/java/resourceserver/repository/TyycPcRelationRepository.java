package resourceserver.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import resourceserver.model.university.TyycPcRelation;

public interface TyycPcRelationRepository extends JpaRepository<TyycPcRelation, Integer> {
}
