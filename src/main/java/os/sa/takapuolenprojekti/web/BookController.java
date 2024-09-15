package os.sa.takapuolenprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import os.sa.takapuolenprojekti.domain.Book;
import os.sa.takapuolenprojekti.domain.BookRepository;


@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @GetMapping("/newbook")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
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

    @GetMapping("/booklist")
    public String Booklist(Model model) {
        //localhost:8080/booklist
        model.addAttribute("books", repository.findAll());

        return "booklist";
    }
}
