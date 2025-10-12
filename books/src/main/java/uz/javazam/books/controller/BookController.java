package uz.javazam.books.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.javazam.books.model.Book;
import uz.javazam.books.service.BookService;

@RestController
@RequestMapping("api/v1")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


}
