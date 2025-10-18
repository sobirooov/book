package uz.javazam.books.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.javazam.books.model.Book;
import java.util.List;

@Repository
public class BookRepository  {

    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> findAll() {
        String sql = "SELECT * FROM book.books";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Book book = new Book();
            book.setId(rs.getLong("id"));
            book.setTitle(rs.getString("title"));
            book.setGenre(rs.getString("genre"));
            book.setYear(rs.getInt("year"));
            return book;
        });
    }

    public Book findById(Long id) {
        String sql = "SELECT * FROM book.books WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Book book = new Book();
            book.setId(rs.getLong("id"));
            book.setTitle(rs.getString("title"));
            book.setGenre(rs.getString("genre"));
            book.setYear(rs.getInt("year"));
            return book;
        });
    }

    public int save(Book book) {
        String sql = "INSERT INTO book.books (title, genre, year) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, book.getTitle(), book.getGenre(), book.getYear());
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM book.books WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int update(Long id, Book book) {
        String sql = "UPDATE book.books SET title = ?, genre = ?, year = ? WHERE id = ?";
        return jdbcTemplate.update(sql, book.getTitle(), book.getGenre(), book.getYear(), id);
    }
}
