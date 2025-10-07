package uz.javazam.books.controller;

import org.springframework.stereotype.Controller;
import uz.javazam.books.service.AuthorService;

@Controller
public class AuthorController {
 private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


}
