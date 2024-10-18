package os.sa.takapuolenprojekti;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import os.sa.takapuolenprojekti.domain.Category;
import os.sa.takapuolenprojekti.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByCategoryidShouldReturnCategory() {
        List<Category> categories = repository.findByCategoryid(1L);

        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Fantasia");
    }

    @Test
    public void createNewCategory() {
        Category category = new Category("Kauhu");
        repository.save(category);
        assertThat(category.getCategoryid()).isNotNull();

    }

    @Test
    public void deleteCategory() {
        List<Category> categories = repository.findByCategoryid(1L);
        repository.deleteById(categories.get(0).getCategoryid());
    }
}
