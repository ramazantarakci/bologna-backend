package resourceserver.model.university;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import resourceserver.model.embedable.ContributionDegree;
import javax.persistence.*;
import java.io.Serializable;

@Data
//@Embeddable
@Entity
@Table(name = "lecture_learning_outcomes")
public class LectureLearningOutcomes implements Serializable {
    @Id
    @Column(nullable = false, unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)//BUNLAR SIKINTI ÇIKARTABİLİR AUTOINCREMENT ÖZELLİĞİNİ ELLE YAPMAMALIYIM AMA TABLODA UNİQ Bİ DEĞER OLMALI
    private int id;
    private String outcome_number;
    private String learning_outcome;
    private ContributionDegree contribution_degree;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id", nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST) //productionda gerekli mi bilmiyorum
    private UniversityLectureContent universityLectureContent;

//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "university_id", nullable = false)
//    @Cascade(org.hibernate.annotations.CascadeType.PERSIST) //productionda gerekli mi bilmiyorum
//    private University university;
}