package resourceserver.model.blog;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.springframework.hateoas.RepresentationModel;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "page_content")
public class PageContent extends RepresentationModel<PageContent> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(length = 5000)
    private String content;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "page_id", nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST) //productionda gerekli mi bilmiyorum
    private Pages page;
}


