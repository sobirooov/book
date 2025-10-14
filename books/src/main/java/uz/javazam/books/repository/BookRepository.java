package uz.javazam.books.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uz.javazam.books.model.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class BookRepository  {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
