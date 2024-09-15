package os.sa.takapuolenprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import os.sa.takapuolenprojekti.domain.BookRepository;


@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @GetMapping("/index")
    public String Index() {

        return "frontpage";
    }
}
