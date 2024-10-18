package os.sa.takapuolenprojekti;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import os.sa.takapuolenprojekti.domain.Book;
import os.sa.takapuolenprojekti.domain.BookRepository;
import os.sa.takapuolenprojekti.domain.Category;


@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = repository.findByAuthor("J.K. Rowling");

        assertThat(books).hasSize(3);
        assertThat(books.get(0).getTitle()).isEqualTo("Harry Potter ja viisasten kivi");
    }

    @Test
    public void createNewBook() {
        Book book = new Book("Harry Potter ja liekehtivä pikari", "J.K. Rowling", 2000, "9789510316923", "24,00", new Category("Fantasia"));
       
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook() {
        List<Book> books = repository.findByAuthor("J.K. Rowling");

        repository.deleteById(books.get(0).getId());
        books = repository.findByAuthor("J.K. Rowling");
        assertThat(books).hasSize(2);
    }
}