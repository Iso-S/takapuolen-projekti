package os.sa.takapuolenprojekti.web;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import os.sa.takapuolenprojekti.domain.Book;
import os.sa.takapuolenprojekti.domain.BookRepository;
import os.sa.takapuolenprojekti.domain.CategoryRepository;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class BookRestController {
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;

    @GetMapping("/books")
        public @ResponseBody List<Book> studentListRest() { //localhost:8080/books
        return (List<Book>) repository.findAll();
    }

    @GetMapping("/books/{id}")
        public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
    	return repository.findById(bookId);
    }
    
}
