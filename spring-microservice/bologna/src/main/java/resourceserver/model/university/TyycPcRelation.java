package resourceserver.model.university;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.springframework.hateoas.RepresentationModel;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tyycpc")
public class TyycPcRelation extends RepresentationModel<TyycPcRelation> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int tyyc_id;
    private int throughput_id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST) //productionda gerekli mi bilmiyorum
    private UniversityDepartment universityDepartment;
}
