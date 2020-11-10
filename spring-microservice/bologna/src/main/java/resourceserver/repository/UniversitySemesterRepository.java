package resourceserver.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import resourceserver.model.university.UniversityDepartment;
import resourceserver.model.university.UniversitySemester;
import java.util.List;

public interface UniversitySemesterRepository extends JpaRepository<UniversitySemester, Integer> {
    List<UniversitySemester> findAllByUniversityDepartment(UniversityDepartment universityDepartment);
}
