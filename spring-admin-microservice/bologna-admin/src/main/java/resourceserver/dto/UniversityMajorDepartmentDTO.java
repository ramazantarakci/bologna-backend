package resourceserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.springframework.hateoas.RepresentationModel;
import resourceserver.model.university.University;
import javax.persistence.*;

@Data
public class  UniversityMajorDepartmentDTO extends RepresentationModel<UniversityMajorDepartmentDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int major_department_id;
    private String major_department_name;
//    private String university_type;///BU FİELD VERİTABANINDA YOK KULLANICIDAN ALINAN BİR VERİ DEĞİL ÜST TABLODAN ÇEKİLEN KOPYA BİR VERİ!!!

    private int  university_id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST) //productionda gerekli mi bilmiyorum
    private University university;
}
