package resourceserver.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import resourceserver.model.blog.PageContent;

public interface PageContentRepository extends JpaRepository<PageContent, Integer> {

}