package resourceserver.model.university;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.springframework.hateoas.RepresentationModel;
import resourceserver.model.embedable.Lecture_type;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "lectures")
public class UniversityLecture  extends RepresentationModel<UniversityLecture> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lecture_id;//dersin kodu

    @Column(nullable = false)
    private String lecture_name;//dersin adı

    //dersin akts kredisi
    private int lecture_ECTS;

    //dersin zorunlu mu yoksa seçmeli mi olduğu sadece iki seçenek
    private Lecture_type lecture_type;

    ///koridnatörün keycloak idsi burada kayıtlı duracak
    private String coordinator_id_from_keycloak;

    //dersin teorik uygulama ve lab saatleri
    private int theoretical_course_hour;
    private int practical_course_hour;
    private int lab_course_hour;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "semester_id", nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private UniversitySemester universitySemester;

    @JsonIgnore//KALDIR İLİŞKİYİ DÜZENLE
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    @JoinColumn(name = "content_id", referencedColumnName = "content_id")
    private UniversityLectureContent universityLectureContent;
}
