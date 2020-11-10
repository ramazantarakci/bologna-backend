package resourceserver.model.university;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import resourceserver.model.embedable.University_type;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "universities")
public class University extends RepresentationModel<University> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int university_id;
    @NotBlank(message = "İSİM ALANI BOŞ BIRAKILAMAZ !")
    private String name;
    @NotBlank(message = "ADRES ALANI BOŞ BIRAKILAMAZ !")
    private String address;
    @NotBlank(message = "HAKKINDA ALANI BOŞ BIRAKILAMAZ !")
    private String about;
//    @NotBlank(message = "TYPE ALANI BOŞ BIRAKILAMAZ !")
    private University_type type;

    //  ALT İLİŞKİ
    @JsonManagedReference
    @OneToMany(mappedBy = "university", fetch = FetchType.LAZY)//  FETCH TYPE LAZY HİÇBİ BOKA YARAMIYOR
    private List<UniversityMajorDepartment> university_majorDepartments = new ArrayList<UniversityMajorDepartment>();
    public void addUniversity_major_department(UniversityMajorDepartment university_majorDepartment){
        this.university_majorDepartments.add(university_majorDepartment);
    }
}