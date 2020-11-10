package resourceserver.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import resourceserver.model.embedable.Lecture_type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
public class UniversityLectureDTO extends RepresentationModel<UniversityLectureDTO> {
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
}
