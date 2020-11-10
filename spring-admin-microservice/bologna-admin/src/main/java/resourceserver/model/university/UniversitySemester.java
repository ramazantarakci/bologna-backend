package resourceserver.model.university;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "semesters")
public class UniversitySemester implements Serializable {//  extends RepresentationModel<UniversitySemester>
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int semester_id;

    @Column(nullable = false, name = "semester_number")
    private int semester_number;//kaçıncı dönem olduğu

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "department_id")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private UniversityDepartment universityDepartment;

    //ALT İLİŞKİ Bir dönemde birden fazla ders olur
    @JsonManagedReference
    @OneToMany(mappedBy = "universitySemester")
    private List<UniversityLecture> universityLectures = new ArrayList<UniversityLecture>();
    public void addUniversityLecture(UniversityLecture universityLecture){
        this.universityLectures.add(universityLecture);
    }
}
