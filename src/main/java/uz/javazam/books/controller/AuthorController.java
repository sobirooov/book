package uz.javazam.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.javazam.books.model.Author;
import uz.javazam.books.service.AuthorService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public ResponseEntity<?> addAuthor(@RequestBody Author author) {
        int result = authorService.addAuthor(author);

        if (result > 0) {
            return ResponseEntity.ok(
                    Map.of(
                            "status", "success",
                            "message", "Author saved",
                            "data", author
                    )
            );
        } else {
            return ResponseEntity.status(500).body(
                    Map.of(
                            "status", "error",
                            "message", "Failed to save author"
                    )
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
        int result = authorService.deleteAuthor(id);

        if (result > 0) {
            return ResponseEntity.ok(
                    Map.of(
                            "status", "success",
                            "message", "Author deleted",
                            "deletedId", id
                    )
            );
        } else {
            return ResponseEntity.status(404).body(
                    Map.of(
                            "status", "error",
                            "message", "Author not found",
                            "requestedId", id
                    )
            );
        }
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor) {
        return authorService.updateAuthor(id, updatedAuthor);
    }
}
