package resourceserver.dto.listdto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class MajorDepartmentListDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int major_department_id;
    private String major_department_name;
}
