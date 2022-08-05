package com.codingdojo.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired //handles dependency injection
	BookService bookService;
	
    //create
	
	@GetMapping("books/new") 
	public String newBook(@ModelAttribute("book") Book book) { //passes in model and adds a new empty Book attribute to it
		return "new.jsp"; //The form in "new.jsp" fills the Book object with form data
	}
    @PostMapping("/books")
    public String create(
    					@Valid @ModelAttribute("book") Book book, //passes Book attribute with form data to the post method
    					BindingResult result //for error handling
    					){
    	if (result.hasErrors()) {
    		return "new.jsp";
    	}
    	bookService.createBook(book);	//saves Book to database
    	return "redirect:/books";
    }
    
	//read all
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
		
	}
	
    //read
	@RequestMapping("/books/{bookId}")
	public String showBook(@PathVariable("bookId") Long bookId, Model model) {
		//Create an instance of the book
		Book book = bookService.findBook(bookId);
		model.addAttribute("book", book);  //String is reference for jsp
		
		return "show.jsp";
	}
	

}
