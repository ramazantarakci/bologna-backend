package resourceserver.model.embedable;
import lombok.Data;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Course_prerequisite {
        private int prerequisite_id;
}
