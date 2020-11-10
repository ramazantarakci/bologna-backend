package resourceserver.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resourceserver.dto.PageContentDTO;
import resourceserver.mapper.BlogMapper;
import resourceserver.model.blog.Pages;
import resourceserver.service.PageContentService;
import resourceserver.service.PagesService;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/")
public class MainPageController {
    private final PagesService pagesService;
    private final PageContentService pageContentService;
    private final BlogMapper mapper;



    @GetMapping
    public List<Pages> getHomePage(){
        List<Pages> pages = pagesService.findAll();
        for (int i = 0; i <pages.size(); i++) {
            for (int j = 0; j < pages.get(i).getPageContentList().size(); j++) {
                pages.get(i).add(linkTo(methodOn(MainPageController.class).getPageContent(pages.get(i).getPageContentList().get(j).getId())).withRel(pages.get(i).getPageContentList().get(j).getName()));
            }
        }
        return pages;
//        return mapper.toPagesDTOs(pages);
    }
    @GetMapping("/pagecontent/{id}")
    public PageContentDTO getPageContent(@PathVariable int id){
        return mapper.toPageContentDTO(pageContentService.findById(id).get());
    }
}
