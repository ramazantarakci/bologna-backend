package resourceserver.dto.subdto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import resourceserver.model.university.UniversityDepartment;

import javax.persistence.*;

@Data
public class PT{
    //    @Column(unique = true, nullable = false)
    @Id//@ElementCollection Yerine Bunu yaptık
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @JsonIgnore
    private String throughput_id;
    private String throughput_content;/// serializer kısmı ayarlandığına bu field kaldırılabilir.

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    @Cascade(CascadeType.PERSIST)
    private UniversityDepartment universityDepartment;
}