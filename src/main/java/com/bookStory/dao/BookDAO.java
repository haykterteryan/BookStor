package com.bookStory.dao;


import com.bookStory.domain.Book;
import com.bookStory.mapper.BookMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;
    private final BookMapper bookMapper;

    public BookDAO(JdbcTemplate jdbcTemplate,BookMapper bookMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.bookMapper = bookMapper;
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


    public List<Book> getByAuthor(String author) {
        List<Book> books = jdbcTemplate
                .query("SELECT * FROM book where author = ?" ,
                        bookMapper,author
                );

        return books;

    }
}
