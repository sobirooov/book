package uz.javazam.books.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.javazam.books.model.Author;

import java.util.List;

@Repository
public class AuthorRepository {

    private final JdbcTemplate jdbcTemplate;

    public AuthorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Author> findAll() {
        String sql = "SELECT * FROM authors";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Author author = new Author();
            author.setId(rs.getLong("id"));
            author.setFullName(rs.getString("full_name"));
            author.setCountry(rs.getString("country"));
            author.setBirthYear(rs.getInt("birth_year"));
            return author;
        });
    }

    public Author findById(int id) {
        String sql = "SELECT * FROM authors WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Author author = new Author();
            author.setId(rs.getLong("id"));
            author.setFullName(rs.getString("full_name"));
            author.setCountry(rs.getString("country"));
            author.setBirthYear(rs.getInt("birth_year"));
            return author;
        });
    }

    public int save(Author author) {
        String sql = "INSERT INTO authors(full_name, country, birth_year) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, author.getFullName(), author.getCountry(), author.getBirthYear());
    }

}
