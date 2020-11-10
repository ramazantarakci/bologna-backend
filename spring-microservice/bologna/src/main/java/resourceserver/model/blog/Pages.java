package resourceserver.model.blog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "pages")
public class Pages extends RepresentationModel<Pages> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    //  ALT İLİŞKİ
    @JsonIgnore
//    @JsonManagedReference
    @OneToMany(mappedBy = "page", fetch = FetchType.LAZY)//  FETCH TYPE LAZY HİÇBİ BOKA YARAMIYOR
    private List<PageContent> pageContentList = new ArrayList<PageContent>();
    public void addPageContent(PageContent pageContent){
        pageContent.setPage(this);
        this.pageContentList.add(pageContent);
    }
}