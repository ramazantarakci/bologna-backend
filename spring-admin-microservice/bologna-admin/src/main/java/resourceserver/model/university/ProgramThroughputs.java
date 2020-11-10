package resourceserver.model.university;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.*;

//@Embeddable
@Data
@Entity
@Table(name = "program_throughputs")
public class ProgramThroughputs {
//    @Column(unique = true, nullable = false)
    @Id//@ElementCollection Yerine Bunu yaptık
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String throughput_id;
    private String throughput_content;/// serializer kısmı ayarlandığına bu field kaldırılabilir.

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    @Cascade(CascadeType.PERSIST)
    private UniversityDepartment universityDepartment;
}