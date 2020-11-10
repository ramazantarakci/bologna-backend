package resourceserver.mapper;

import org.mapstruct.Mapper;
import resourceserver.dto.PageContentDTO;
import resourceserver.dto.PagesDTO;
import resourceserver.model.blog.PageContent;
import resourceserver.model.blog.Pages;

import java.util.List;

@Mapper
public interface BlogMapper {
    PagesDTO toPagesDTO(Pages page);
    PageContentDTO toPageContentDTO(PageContent pageContent);
    List<PagesDTO> toPagesDTOs(List<Pages> pages);
    List<PageContentDTO> toPageContentDTOs(List<PageContent> pageContents);
}
