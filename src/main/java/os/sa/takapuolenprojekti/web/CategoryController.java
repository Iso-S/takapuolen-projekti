package os.sa.takapuolenprojekti.web;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import os.sa.takapuolenprojekti.domain.Category;
import os.sa.takapuolenprojekti.domain.CategoryRepository;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository repository;

    @GetMapping("/newcategory")
    public String newCategory(Model model) {
        model.addAttribute("category", new Category());
        //localhost:8080/newcategory

        return "newcategory";
    }

    @PostMapping("/savecategory")
    public String saveCategory(Category category) {
        repository.save(category);

        return "redirect:categorylist";
    }

    @GetMapping("/deletecategory/{categoryid}")
    public String deleteCategory(@PathVariable("categoryid") Long categoryid, Model model) {
        repository.deleteById(categoryid);

        return "redirect:../categorylist";
    }

    @GetMapping("/categorylist")
    public String Categorylist(Model model) {
        //localhost:8080/categorylist
        model.addAttribute("categories", repository.findAll());

        return "categorylist";
    }

}
