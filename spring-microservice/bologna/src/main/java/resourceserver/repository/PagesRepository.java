package resourceserver.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import resourceserver.model.blog.Pages;

//@Repository
public interface PagesRepository extends JpaRepository<Pages, Integer> {

}
