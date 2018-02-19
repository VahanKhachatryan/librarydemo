package libraryam.librarydemo.controller;

import libraryam.librarydemo.model.Author;
import libraryam.librarydemo.model.Book;
import libraryam.librarydemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/addBook")
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult result) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (result.hasErrors()) {
            for (ObjectError objectError : result.getAllErrors()) {
                sb.append(objectError.getDefaultMessage() + "<br>");
            }
            return "redirect:/home?message=" + sb.toString();
        }
        bookRepository.save(book);
        return "redirect:/home";
    }

    @PostMapping("/bookView")
    public String bookView() {
        return "redirect:/home";
    }

}
