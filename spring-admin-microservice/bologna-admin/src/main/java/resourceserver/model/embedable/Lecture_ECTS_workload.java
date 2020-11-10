package resourceserver.model.embedable;
import lombok.Data;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Lecture_ECTS_workload {
    private Lecture_ECTS_workload_type type;
    private int lesson_duration;
    private int non_exam_study_time;
    private int presentation_and_seminar_preparation;
    private int lecture_specific_internship;
    private int workshop_laboratory_applications;
    private int working_out_of_class;
    private int projects;
    private int homeworks;
    private int quizzes;
    private int mid_term;
    private int final_exam;
}
