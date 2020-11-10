package resourceserver.model.university;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.springframework.hateoas.RepresentationModel;
import resourceserver.model.embedable.Department_about;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "departments")
public class UniversityDepartment  extends RepresentationModel<UniversityDepartment>implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int department_id;

    @Column(nullable = false)
    private String department_name;

    @Embedded
    Department_about department_about = new Department_about();

    //@JsonIgnore
//    @ElementCollection
//    @CollectionTable(name = "university_program_throughputs", joinColumns = @JoinColumn(name = "department_id", nullable = false))
    @JsonManagedReference
    @OneToMany(mappedBy = "universityDepartment")
    private List<ProgramThroughputs> programThroughputs = new ArrayList<ProgramThroughputs>();
    public void addProgramThroughput(ProgramThroughputs pt){
        pt.setThroughput_id("P.Ç "+(this.programThroughputs.size()+1));
        pt.setUniversityDepartment(this);////BU ÇOK İŞE YARAR                  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        this.programThroughputs.add(pt);
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "universityDepartment")
    private List<TYYC> tyycList = new ArrayList<TYYC>();
    public void addTYYC(TYYC tyyc){
        tyyc.setTyyc_id("T.Y.Y.Ç "+(this.tyycList.size()+1));
        tyyc.setUniversityDepartment(this);////BU ÇOK İŞE YARAR                 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        this.tyycList.add(tyyc);
    }

    //  ÜST İLİŞKİ
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "major_department_id", nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST) //productionda gerekli mi bilmiyorum
    private UniversityMajorDepartment universityMajorDepartment;

    // ALT İLİŞKİ
    //@JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "universityDepartment")
    private List<UniversitySemester> universitySemesters = new ArrayList<UniversitySemester>();
    public void addUniversitySemester(UniversitySemester universitySemester){
        this.universitySemesters.add(universitySemester);
    }

//    Departmandan tyyc-pc ilişkisine bir çok bağlantı
    @JsonManagedReference
    @OneToMany(mappedBy = "universityDepartment", fetch = FetchType.LAZY)//  FETCH TYPE LAZY HİÇBİ BOKA YARAMIYOR
    private List<TyycPcRelation> tyycPcRelations = new ArrayList<TyycPcRelation>();
    public void addTyycPcRelation(TyycPcRelation tyycPcRelation){
        tyycPcRelation.setUniversityDepartment(this);
        this.tyycPcRelations.add(tyycPcRelation);
    }
}
