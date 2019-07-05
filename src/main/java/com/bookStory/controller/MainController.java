package com.bookStory.controller;

import com.bookStory.dao.BookDAO;
import com.bookStory.domain.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class MainController {

    private BookDAO bookDAO;


    public MainController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getByAuthor(@RequestParam("author") String author){
        System.out.println(author);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity  add(@RequestBody Book book){
        bookDAO.add(book);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity  update(@PathVariable("id") int id, @RequestBody Book book){
        bookDAO.update(id,book);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity  delete(@PathVariable int id){
        bookDAO.delete(id);

        return ResponseEntity.ok().build();
    }







}
