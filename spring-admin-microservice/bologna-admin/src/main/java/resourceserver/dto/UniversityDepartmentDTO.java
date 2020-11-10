package resourceserver.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.springframework.hateoas.RepresentationModel;
import resourceserver.model.embedable.Department_about;
import resourceserver.model.university.UniversityMajorDepartment;

import javax.persistence.*;

@Data
public class UniversityDepartmentDTO extends RepresentationModel<UniversityDepartmentDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int department_id;

    @Column(nullable = false)
    private String department_name;

    @Embedded
    Department_about department_about = new Department_about();

    private int major_department_id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "major_department_id", nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST) //productionda gerekli mi bilmiyorum
    private UniversityMajorDepartment universityMajorDepartment;
}
