package com.bookStory.controller;

import com.bookStory.domain.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getByAuthor(@RequestParam("author") String author){
        System.out.println(author);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity  add(@RequestBody Book book){
        System.out.println(book);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity  update(@PathVariable("id") int id, @RequestBody Book book){
        System.out.println(id + " " + book);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity  delete(@PathVariable int id){
        System.out.println(id);

        return ResponseEntity.ok().build();
    }







}
