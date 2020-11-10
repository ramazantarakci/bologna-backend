package resourceserver.model.embedable;
import lombok.Data;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Course_methods_and_techniques {
    private int number;
    private String method;
}
