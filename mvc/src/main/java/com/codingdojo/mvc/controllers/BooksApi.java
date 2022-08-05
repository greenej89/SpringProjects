package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;


@RestController
public class BooksApi {
    private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    
    //read all books
    @RequestMapping("/api/books")
    public List<Book> index() {
    	return bookService.allBooks();
    }
    
    //create
    @PostMapping("/api/books")
    public Book create(@RequestParam(value="title") String title, 
    					@RequestParam(value="description") String desc, 
    					@RequestParam(value="language") String lang, 
    					@RequestParam(value="pages") Integer numOfPages){
    
    	Book book = new Book(title, desc, lang, numOfPages);
    	return bookService.createBook(book);
    }
    //read
    @RequestMapping("api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
    	Book book = bookService.findBook(id);
    	return book;
    }
    // update
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id, 
    					@RequestParam(value="title") String title, 
    					@RequestParam(value="description") String desc, 
    					@RequestParam(value="language") String lang, 
    					@RequestParam(value="pages") Integer numOfPages) {
		// we create a new Book object with the values we passed in
		Book book = new Book(title, desc, lang, numOfPages);
		// we then set the ID of the new Book object to equal the ID of the Book we are updating
		book.setId(id);
		// now we can use our bookService to update the book
		Book updatedBook = bookService.updateBook(book);
        return updatedBook;
    }
    
    //delete
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}