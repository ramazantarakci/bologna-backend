package resourceserver.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import resourceserver.model.blog.Pages;

public interface PagesRepository extends JpaRepository<Pages, Integer> {

}
