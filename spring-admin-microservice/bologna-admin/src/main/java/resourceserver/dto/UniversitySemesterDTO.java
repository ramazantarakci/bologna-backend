package resourceserver.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import resourceserver.model.university.UniversityLecture;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class UniversitySemesterDTO{// extends RepresentationModel<UniversitySemesterDTO>
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int semester_id;

    @Column(nullable = false, name = "semester_number")
    private int semester_number;//kaçıncı dönem olduğu

    @JsonManagedReference
    @OneToMany(mappedBy = "universitySemester")
    private List<UniversityLecture> universityLectures = new ArrayList<UniversityLecture>();
    public void addUniversityLecture(UniversityLecture universityLecture){
        this.universityLectures.add(universityLecture);
    }
}
