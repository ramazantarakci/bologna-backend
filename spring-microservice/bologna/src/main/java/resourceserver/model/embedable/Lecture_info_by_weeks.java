package resourceserver.model.embedable;
import lombok.Data;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Lecture_info_by_weeks {
    private int week_number;//hangi hafta olduğu
    private String lesson_content_that_week;//o haftanın ders içeriği
    private String lesson_material_that_week;//o hafta ders için kullanılacak kaynaklar
}
