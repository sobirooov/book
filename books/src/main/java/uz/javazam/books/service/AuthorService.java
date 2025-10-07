package uz.javazam.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.javazam.books.repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
}
