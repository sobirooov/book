package uz.javazam.books.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.javazam.books.model.Book;
import uz.javazam.books.service.BookService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        int result =  bookService.addBook(book);

        if (result > 0) {
            return ResponseEntity.ok(
                    Map.of(
                            "status", "success",
                            "message", "Book saved",
                            "data", book
                    )
            );
        } else  {
            return ResponseEntity.status(500).body(
                    Map.of(
                            "status", "error",
                            "message", "Failed to save book"
                    )
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        int result = bookService.deleteBook(id);

        if (result > 0) {
            return ResponseEntity.ok(
                    Map.of(
                            "status", "success",
                            "message", "Book deleted",
                            "deletedId", id
                    )
            );
        } else {
            return ResponseEntity.status(404).body(
                    Map.of(
                            "status", "error",
                            "message", "Book not found",
                            "requestedId", id
                    )
            );
        }
    }


    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updatedBook(id, book);
    }

}
