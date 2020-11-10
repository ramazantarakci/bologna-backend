package resourceserver.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import resourceserver.dto.PageContentDTO;
import resourceserver.dto.PagesDTO;
import resourceserver.model.blog.PageContent;
import resourceserver.model.blog.Pages;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.7 (JetBrains s.r.o.)"
)
@Component
public class BlogMapperImpl implements BlogMapper {

    @Override
    public PagesDTO toPagesDTO(Pages page) {
        if ( page == null ) {
            return null;
        }

        PagesDTO pagesDTO = new PagesDTO();

        pagesDTO.setId( page.getId() );
        pagesDTO.setName( page.getName() );

        return pagesDTO;
    }

    @Override
    public PageContentDTO toPageContentDTO(PageContent pageContent) {
        if ( pageContent == null ) {
            return null;
        }

        PageContentDTO pageContentDTO = new PageContentDTO();

        pageContentDTO.setContent( pageContent.getContent() );

        return pageContentDTO;
    }

    @Override
    public List<PagesDTO> toPagesDTOs(List<Pages> pages) {
        if ( pages == null ) {
            return null;
        }

        List<PagesDTO> list = new ArrayList<PagesDTO>( pages.size() );
        for ( Pages pages1 : pages ) {
            list.add( toPagesDTO( pages1 ) );
        }

        return list;
    }

    @Override
    public List<PageContentDTO> toPageContentDTOs(List<PageContent> pageContents) {
        if ( pageContents == null ) {
            return null;
        }

        List<PageContentDTO> list = new ArrayList<PageContentDTO>( pageContents.size() );
        for ( PageContent pageContent : pageContents ) {
            list.add( toPageContentDTO( pageContent ) );
        }

        return list;
    }
}
