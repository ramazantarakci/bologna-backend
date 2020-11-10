package resourceserver.model.embedable;
import lombok.Data;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Course_category {
    private int basic_sciences;
    private int engineering_scineces;
    private int social_sciences;
    private int education_sciences;
    private int art_sciences;
    private int health_sciences;
    private int agricultural_sciences;
}
