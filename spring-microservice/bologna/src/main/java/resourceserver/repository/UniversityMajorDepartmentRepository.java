package resourceserver.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import resourceserver.model.university.University;
import resourceserver.model.university.UniversityMajorDepartment;

import java.util.List;

//@Repository
public interface UniversityMajorDepartmentRepository extends JpaRepository<UniversityMajorDepartment, Integer> {
//    List<UniversityMajorDepartment> findAllByUniversity_University_id();
//    List<UniversityMajorDepartment> findUniversityMajorDepartmentsByUniversity_University_id(int id);///çok ümitlendim ama çalışmadı
    List<UniversityMajorDepartment> findAllByUniversity(University university);
}
