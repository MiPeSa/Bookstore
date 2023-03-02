package k23BE.Bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import k23BE.Bookstore.domain.Book;
import k23BE.Bookstore.domain.BookRepository;
import k23BE.Bookstore.domain.CategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class RestBookController {
	private static final Logger log = LoggerFactory.getLogger(RestBookController.class);
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	// list of books
	@GetMapping("/books")
	public Iterable<Book> getBooks() { 
		log.info("//fetch and return books");
		return bookRepository.findAll();
	}

	
	// find one car and return it
	@GetMapping("/books/{id}")
	Optional<Book> getCar(@PathVariable Long id) {
		log.info("find book, id = " + id);
		return bookRepository.findById(id);
	}

}
