package uz.javazam.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.javazam.books.model.Author;
import uz.javazam.books.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id){
        return authorRepository.findById(id);
    }
    public String addAuthor(Author author){
        int rows = authorRepository.save(author);
        return rows > 0 ? "Author added successfully!" : "Failed to add author!";
    }
    public String deleteAuthor(Long id){
        int rows = authorRepository.deleteById(id);
        return rows > 0 ? "Author deleted successfully!" : "Author not found!";
    }
    public Author updateAuthor(Long id, Author updatedAuthor) {
        Author existingAuthor = authorRepository.findById(id);
        if (existingAuthor == null) {
            throw new RuntimeException("Author not found with id: " + id);
        }

        authorRepository.update(id, updatedAuthor);
        return authorRepository.findById(id);
    }
}
