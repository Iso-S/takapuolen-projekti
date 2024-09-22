package os.sa.takapuolenprojekti.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByName(String name);
    List<Category> findByCategoryid(Long categoryid);
}
