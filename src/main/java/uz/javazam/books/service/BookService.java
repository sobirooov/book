package uz.javazam.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.javazam.books.model.Author;
import uz.javazam.books.model.Book;
import uz.javazam.books.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;


    public List<Book> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        for(Book book : books){
            fillAuthors(book);
        }
        return books;
    }

    public Book getBookById(Long id) {
        Book result = bookRepository.findById(id);
        if (result != null) {
            fillAuthors(result);
        }
        return result;
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

    private void fillAuthors(Book book) {
       List<Author> authors = authorService.getAuthorsByBookId(book.getId());
       book.setAuthors(authors);
    }

}
