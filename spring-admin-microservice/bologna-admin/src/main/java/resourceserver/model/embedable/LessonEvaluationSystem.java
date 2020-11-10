package resourceserver.model.embedable;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
//@Entity
//@Table(name = "lesson_evaluation_system")
@Embeddable
public class LessonEvaluationSystem implements Serializable {//  extends RepresentationModel<LessonEvaluationSystem>
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
////    @Id // DENEDİM OLMADI
//    @ManyToOne
//    @JoinColumn(name = "lecture_id", nullable = false)
//    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
//    private UniversityLectureContent universityLectureContent;

    //hangi kolon olduğu
    private Evaluation_type evaluation_type;
    private int semester_studies;
    private int attendance;
    private int practical_exam;
    private int course_specific_internship;
    private int quiz;
    private int homework;
    private int presentation;
    private int projects;
    private int lab_practise;
    private int working_out_of_class;
//    private int mid_term;
//    private int final_exam;
//iki tanesine gerek yok type zaten ayrım yapıyor
    private int exam;
    private int other_works;
}
