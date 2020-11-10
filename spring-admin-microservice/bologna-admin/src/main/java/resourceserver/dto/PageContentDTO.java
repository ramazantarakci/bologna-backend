package resourceserver.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class PageContentDTO extends RepresentationModel<PageContentDTO> implements Serializable {
    @Column(length = 5000)
    private String content;
}
