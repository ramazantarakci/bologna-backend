package resourceserver.model.embedable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Department_about {
    @JsonProperty("Bölüm Başkanı")
    private String head_of_department = "Bölüm Başkanı";
    @JsonProperty("Erasmus Kordinatörü")
    private String erasmus_coordinator = "Erasmus Kordinatörü";
    @JsonProperty("Farabi Kordinatörü")
    private String farabi_coordinator = "Farabi Kordinatörü";
    @JsonProperty("AKTS Kordinatörü")
    private String akts_coordinator = "AKTS Kordinatörü";
    @JsonProperty("Departman Hakkında Bilgi")
    private String about_of_department = "Departman Hakkında Bilgi";
    @JsonProperty("Bölümün Vizyonu")
    private String vision_of_department = "Bölümün Vizyonu";
    @JsonProperty("Bölümün Misyonu")
    private String mission_of_department = "Bölümün Misyonu";
    @JsonProperty("Bölümün Amacı")
    private String purpose_of_department = "Bölümün Amacı";
    @JsonProperty("Bölümün Anadili")
    private String education_language = "Bölümün Anadili";
    @JsonProperty("Bölüm Hakkında")
    private String education_description = "Bölüm Hakkında";
    @JsonProperty("Bölüme Kabul Şartları")
    private String admission_requirements = "Bölüme kabul Şartları";
    @JsonProperty("Önceki Öğrenmenin Tanınması")
    private String recognition_of_prior_learning = "önceki öğrenmenin tanınması";
    @JsonProperty("Değerlendirme ve not verme")
    private String assessment_and_grading = "değerlendirme ve not verme";
    @JsonProperty("Ölçme ve Değerlendirme İlkeleri")
    private String meauserment_and_evaluation_principles = "ölçme ve değerlendirme ilkeleri";
    @JsonProperty("Mezunların Meslek Profilleri")
    private String occupational_profiles_of_graduates = "mezunların meslek profilleri";
    @JsonProperty("Üst Programlara Geçiş")
    private String transition_to_upper_programs = "üst programlara geçiş";
}
