package resourceserver.model.university;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "llo_pt_relation")
public class LLO_PT_Relation implements Serializable {//extends RepresentationModel<LLO_PT_Relation>
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int learning_outcome_id;
    @Column
    private int throughput_id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id", nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST) //productionda gerekli mi bilmiyorum
    private UniversityLectureContent universityLectureContent;

}
