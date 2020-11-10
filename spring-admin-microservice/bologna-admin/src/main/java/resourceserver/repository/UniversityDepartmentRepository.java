package resourceserver.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import resourceserver.model.university.UniversityDepartment;
import resourceserver.model.university.UniversityMajorDepartment;

import java.util.List;

public interface UniversityDepartmentRepository  extends JpaRepository<UniversityDepartment, Integer> {
    List<UniversityDepartment> findAllByUniversityMajorDepartment(UniversityMajorDepartment majorDepartment);
}
