package uz.javazam.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import uz.javazam.books.model.Book;
import uz.javazam.books.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id);
    }
    public String addBook(Book book) {
        int result = bookRepository.save(book);
        if (result > 0) {
            return "Book successfully added!";
        } else {
            return "Failed to add book!";
        }
    }

    public String deleteBook(Long id) {
        int rows = bookRepository.deleteById(id);
        return rows > 0 ? "Book deleted successfully!" : "Failed to delete book";
    }


    public Book updatedBook(Long id, Book updatedBook) {
        Book existingBook = bookRepository.findById(id);
        if (existingBook == null) {
            throw new RuntimeException("Author not found with id: " + id);
        }

        bookRepository.update(id, updatedBook);
        return bookRepository.findById(id);
    }

}
