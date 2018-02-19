package libraryam.librarydemo.controller;

import libraryam.librarydemo.model.Author;
import libraryam.librarydemo.model.Book;
import libraryam.librarydemo.repository.AuthorRepository;
import libraryam.librarydemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
@Controller
public class MainController {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(ModelMap map, @RequestParam(value = "message", required = false) String message) {
        map.addAttribute("authors", authorRepository.findAll());
        map.addAttribute("books", bookRepository.findAll());
        map.addAttribute("message", message != null ? message : "Welcome");
        map.addAttribute("author", new Author());
        map.addAttribute("book", new Book());
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "redirect:/home";
    }





}
