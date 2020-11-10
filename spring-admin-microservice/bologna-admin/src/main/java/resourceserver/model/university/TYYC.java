package resourceserver.model.university;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;

@Data
@Entity
@Table(name = "tyyc")
public class TYYC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tyyc_id;
    private String tyyc_content;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private UniversityDepartment universityDepartment;

}
