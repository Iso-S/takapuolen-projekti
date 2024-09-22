package os.sa.takapuolenprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import os.sa.takapuolenprojekti.domain.Book;
import os.sa.takapuolenprojekti.domain.BookRepository;
import os.sa.takapuolenprojekti.domain.CategoryRepository;


@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;

    @GetMapping("/newbook")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        //localhost:8080/newbook

        return "newbook";
    }

    @PostMapping("/save")
    public String save(Book book) {
        repository.save(book);

        return "redirect:booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        repository.deleteById(id);

        return "redirect:../booklist";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", repository.findById(id));

        return "editbook";
    }

    @GetMapping("/booklist")
    public String Booklist(Model model) {
        //localhost:8080/booklist
        model.addAttribute("books", repository.findAll());

        return "booklist";
    }
}

//http://localhost:8080/h2-console