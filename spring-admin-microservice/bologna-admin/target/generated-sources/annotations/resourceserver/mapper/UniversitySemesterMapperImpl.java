package resourceserver.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import resourceserver.dto.UniversitySemesterDTO;
import resourceserver.model.university.UniversityLecture;
import resourceserver.model.university.UniversitySemester;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.7 (JetBrains s.r.o.)"
)
@Component
public class UniversitySemesterMapperImpl implements UniversitySemesterMapper {

    @Override
    public UniversitySemesterDTO toUniversitySemesterDTO(UniversitySemester universitySemester) {
        if ( universitySemester == null ) {
            return null;
        }

        UniversitySemesterDTO universitySemesterDTO = new UniversitySemesterDTO();

        universitySemesterDTO.setSemester_id( universitySemester.getSemester_id() );
        universitySemesterDTO.setSemester_number( universitySemester.getSemester_number() );
        List<UniversityLecture> list = universitySemester.getUniversityLectures();
        if ( list != null ) {
            universitySemesterDTO.setUniversityLectures( new ArrayList<UniversityLecture>( list ) );
        }
        else {
            universitySemesterDTO.setUniversityLectures( null );
        }

        return universitySemesterDTO;
    }

    @Override
    public UniversitySemester toUniversitySemester(UniversitySemesterDTO universitySemesterDTO) {
        if ( universitySemesterDTO == null ) {
            return null;
        }

        UniversitySemester universitySemester = new UniversitySemester();

        universitySemester.setSemester_id( universitySemesterDTO.getSemester_id() );
        universitySemester.setSemester_number( universitySemesterDTO.getSemester_number() );
        List<UniversityLecture> list = universitySemesterDTO.getUniversityLectures();
        if ( list != null ) {
            universitySemester.setUniversityLectures( new ArrayList<UniversityLecture>( list ) );
        }
        else {
            universitySemester.setUniversityLectures( null );
        }

        return universitySemester;
    }
}
