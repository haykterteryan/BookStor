package com.bookStory.dao;


import com.bookStory.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public void add(Book book) {
        String query = "insert into book (title, author) VALUES (?,?)";
        jdbcTemplate.update(query, book.getTitle(),book.getAuthor());
    }

    public void update(int id, Book book) {
        String query ="UPDATE book SET title = ?, author = ?  where id = ?";
        jdbcTemplate.update(query,book.getTitle(),book.getAuthor(),id);
    }

    public void delete(int id) {
        String query ="DELETE from book where id = ?";
        jdbcTemplate.update(query,id);
    }
}
