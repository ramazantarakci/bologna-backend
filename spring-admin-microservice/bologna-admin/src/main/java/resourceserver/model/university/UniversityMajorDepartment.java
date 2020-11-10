package resourceserver.model.university;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.springframework.hateoas.RepresentationModel;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "major_departments")
public class UniversityMajorDepartment extends RepresentationModel<UniversityMajorDepartment> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int major_department_id;

    @Column(nullable = false)
    @NotBlank(message = "ANA DEPARTMAN ADI ALANI BOŞ BIRAKILAMAZ !")
    private String major_department_name;

    //  ÜST İLİŞKİ birden fazla ana departman bir fakülteye aittir
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST) //productionda gerekli mi bilmiyorum
    private University university;

    //  ALT İLİŞKİ birden fazla bölüm bir anadalın altında bulunur.
    @JsonManagedReference
    @OneToMany(mappedBy = "universityMajorDepartment", fetch = FetchType.LAZY)
    private List<UniversityDepartment> universityDepartments = new ArrayList<UniversityDepartment>();
    public void addFacultyDepartment(UniversityDepartment universityDepartment){
        this.universityDepartments.add(universityDepartment);
    }
}
