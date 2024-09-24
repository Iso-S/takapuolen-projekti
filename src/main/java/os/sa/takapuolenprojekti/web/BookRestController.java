package os.sa.takapuolenprojekti.web;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value="/books", method = RequestMethod.GET)
        public @ResponseBody List<Book> studentListRest() {
        return (List<Book>) repository.findAll();
    }

    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
        public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
    	return repository.findById(bookId);
    }
    

}
