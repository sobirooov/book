package uz.javazam.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public int addBook(Book book) {
        return bookRepository.save(book);
    }

    public int deleteBook(Long id) {
        return bookRepository.deleteById(id);
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
