package resourceserver.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import resourceserver.dto.UniversityDTO;
import resourceserver.dto.listdto.UniversityListDTO;
import resourceserver.dto.subdto.UniversityNameListDTO;
import resourceserver.model.university.University;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.7 (JetBrains s.r.o.)"
)
@Component
public class UniversityMapperImpl implements UniversityMapper {

    @Override
    public UniversityDTO toUniversityDTO(University university) {
        if ( university == null ) {
            return null;
        }

        UniversityDTO universityDTO = new UniversityDTO();

        universityDTO.setUniversity_id( university.getUniversity_id() );
        universityDTO.setName( university.getName() );
        universityDTO.setAddress( university.getAddress() );
        universityDTO.setAbout( university.getAbout() );
        universityDTO.setType( university.getType() );

        return universityDTO;
    }

    @Override
    public UniversityListDTO toUniversityListDTO(University university) {
        if ( university == null ) {
            return null;
        }

        UniversityListDTO universityListDTO = new UniversityListDTO();

        universityListDTO.setUniversity_id( university.getUniversity_id() );
        universityListDTO.setName( university.getName() );
        universityListDTO.setType( university.getType() );

        return universityListDTO;
    }

    @Override
    public University toUniversity(UniversityDTO dto) {
        if ( dto == null ) {
            return null;
        }

        University university = new University();

        university.setUniversity_id( dto.getUniversity_id() );
        university.setName( dto.getName() );
        university.setAddress( dto.getAddress() );
        university.setAbout( dto.getAbout() );
        university.setType( dto.getType() );

        return university;
    }

    @Override
    public University toUniversity(UniversityListDTO dto) {
        if ( dto == null ) {
            return null;
        }

        University university = new University();

        university.setUniversity_id( dto.getUniversity_id() );
        university.setName( dto.getName() );
        university.setType( dto.getType() );

        return university;
    }

    @Override
    public List<UniversityNameListDTO> toUniversityNameListDTO(List<University> universities) {
        if ( universities == null ) {
            return null;
        }

        List<UniversityNameListDTO> list = new ArrayList<UniversityNameListDTO>( universities.size() );
        for ( University university : universities ) {
            list.add( universityToUniversityNameListDTO( university ) );
        }

        return list;
    }

    protected UniversityNameListDTO universityToUniversityNameListDTO(University university) {
        if ( university == null ) {
            return null;
        }

        UniversityNameListDTO universityNameListDTO = new UniversityNameListDTO();

        universityNameListDTO.setUniversity_id( university.getUniversity_id() );
        universityNameListDTO.setName( university.getName() );

        return universityNameListDTO;
    }
}
