package resourceserver.mapper;

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
    public Pages toPages(PagesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Pages pages = new Pages();

        pages.setId( dto.getId() );
        pages.setName( dto.getName() );

        return pages;
    }

    @Override
    public PageContent toPages(PageContentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PageContent pageContent = new PageContent();

        pageContent.setContent( dto.getContent() );

        return pageContent;
    }
}
