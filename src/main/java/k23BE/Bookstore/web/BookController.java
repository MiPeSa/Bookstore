package k23BE.Bookstore.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k23BE.Bookstore.BookstoreApplication;
import k23BE.Bookstore.domain.Book;
import k23BE.Bookstore.domain.BookRepository;
import k23BE.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping(value= "/main")
	public String showMainPage() {
		return "index";
	}
	
	@RequestMapping(value = { "/booklist", "/" } )
	public String showBooklist(Model model) {
		model.addAttribute("books", bookRepository.findAll());
			return "booklist";
	}
	
	@GetMapping("/addBook")
	public String newBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "newBook";
	}
	
	@GetMapping("delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		bookRepository.deleteById(id);
		return "redirect:/booklist";
	}
	
	@GetMapping("edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookRepository.findById(id));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editBook";
	}
	
	@PostMapping("saveBook")
	public String saveBook(@Valid Book book, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			log.info("some validation error happened");
			model.addAttribute("book", book);
			model.addAttribute("categories", categoryRepository.findAll());
			return "newBook";
		}
		
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
}
