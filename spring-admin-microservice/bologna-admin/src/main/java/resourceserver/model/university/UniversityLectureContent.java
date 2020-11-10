package resourceserver.model.university;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import resourceserver.model.embedable.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "lecture_contents")
public class UniversityLectureContent implements Serializable {//extends RepresentationModel<UniversityLectureContent>
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int content_id;

    //Dersin Ön koşulu
    @ElementCollection
    @CollectionTable(name = "course_prerequisite", joinColumns = @JoinColumn(name = "content_id", nullable = false))
    private List<Course_prerequisite> course_prerequisites = new ArrayList<Course_prerequisite>();
    public void addCourse_prerequisite(Course_prerequisite course_prerequisite){
        this.course_prerequisites.add(course_prerequisite);
    }

    //Dersin Amacı
    @NotBlank(message = "DERS AMACI ALANI BOŞ BIRAKILAMAZ !")
    private String course_purpose;

    @JsonIgnore
    @OneToOne(mappedBy = "universityLectureContent")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private UniversityLecture universityLecture;

    //DERS DEĞERLENDİRME SİSTEMİ
    //@OneToMany(mappedBy = "universityLectureContent")
    @ElementCollection
    @CollectionTable(name = "lesson_evaluation_system", joinColumns = @JoinColumn(name = "lecture_id",nullable = false))
    private List<LessonEvaluationSystem> lessonEvaluationSystems = new ArrayList<LessonEvaluationSystem>();
    public void addLessonEvaluationSystem(LessonEvaluationSystem lessonEvaluationSystem){
        this.lessonEvaluationSystems.add(lessonEvaluationSystem);
    }

    // DERSİN HAFTALARA GÖRE İÇERİK BİLGİLERİ
    @ElementCollection
    @CollectionTable(name = "university_lecture_info_by_weeks", joinColumns = @JoinColumn(name = "content_id",nullable = false))
    private List<Lecture_info_by_weeks> lecture_info_by_weeks = new ArrayList<Lecture_info_by_weeks>();
    public void addLecture_info_by_weeks(String lesson_content_that_week, String lesson_material_that_week){
        Lecture_info_by_weeks temp = new Lecture_info_by_weeks();
        temp.setWeek_number(this.lecture_info_by_weeks.size()+1);
        temp.setLesson_content_that_week(lesson_content_that_week);
        temp.setLesson_material_that_week(lesson_material_that_week);
        this.lecture_info_by_weeks.add(temp);
    }

    //DERS ÖĞRENİM ÇIKTILARI
//    @ElementCollection
//    @CollectionTable(name = "university_lecture_learning_outcomes", joinColumns = @JoinColumn(name = "content_id", nullable = false))
    @JsonManagedReference
    @OneToMany(mappedBy = "universityLectureContent", fetch = FetchType.LAZY)//  FETCH TYPE LAZY HİÇBİ BOKA YARAMIYOR
    private List<LectureLearningOutcomes> lecture_learningOutcomes = new ArrayList<LectureLearningOutcomes>();
    public void addLectureLearningOutcomes(LectureLearningOutcomes learningOutcome){
        learningOutcome.setOutcome_number("D.Ö.Ç "+(this.lecture_learningOutcomes.size()+1));
        learningOutcome.setUniversityLectureContent(this);
        this.lecture_learningOutcomes.add(learningOutcome);
    }

    //DERS AKTS İŞ YÜKÜ
    @ElementCollection
    @CollectionTable(name = "university_lecture_ECTS_workload", joinColumns = @JoinColumn(name = "content_id", nullable = false))
    private List<Lecture_ECTS_workload> lecture_ects_workload = new ArrayList<Lecture_ECTS_workload>();
    public void addLecture_ECTS_workload(Lecture_ECTS_workload lecture_ects_workload){
        this.lecture_ects_workload.add(lecture_ects_workload);
    }

    //DERS YÖNTEM ve TEKNİKLERİ
    @ElementCollection
    @CollectionTable(name = "university_course_methods_and_techniques", joinColumns = @JoinColumn(name = "content_id", nullable = false))
    private List<Course_methods_and_techniques> course_methods_and_techniques = new ArrayList<Course_methods_and_techniques>();
    public void addCourse_methods_and_techniques(String method){
        Course_methods_and_techniques temp = new Course_methods_and_techniques();
        temp.setMethod(method);
        temp.setNumber(this.course_methods_and_techniques.size()+1);
        this.course_methods_and_techniques.add(temp);
    }

    //DERS ÖĞRETİM ÜYELERİ
    @ElementCollection
    @CollectionTable(name = "lecturers_of_the_course", joinColumns = @JoinColumn(name = "content_id", nullable = false))
    private List<String> lecturers_of_the_course = new ArrayList<String>();
    public void addLecturer_of_the_course(String Lectuer_id){
        this.lecturers_of_the_course.add(Lectuer_id);
    }

    //DERS KATEGORİSİ tabloya gömülü
    @Embedded
    private Course_category course_category = new Course_category();

    //DERS ÇIKTISI PROGRAM ÇIKTISI İLİŞKİSİ
    @JsonManagedReference
    @OneToMany(mappedBy = "universityLectureContent", fetch = FetchType.LAZY)//  FETCH TYPE LAZY HİÇBİ BOKA YARAMIYOR
    private List<LLO_PT_Relation> llo_pt_relations = new ArrayList<LLO_PT_Relation>();
    public void addLLO_PT_Relation(LLO_PT_Relation relation){
        relation.setUniversityLectureContent(this);
        llo_pt_relations.add(relation);
    }

}

