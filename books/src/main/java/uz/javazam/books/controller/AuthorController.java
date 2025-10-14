package uz.javazam.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.javazam.books.model.Author;
import uz.javazam.books.service.AuthorService;

import java.util.List;


@RestController
public class AuthorController{

    @Autowired
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable int id){
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public String addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    @DeleteMapping
    public String deleteAuthorById(@PathVariable Long id){
        return authorService.deleteAuthor(id);
    }
}
