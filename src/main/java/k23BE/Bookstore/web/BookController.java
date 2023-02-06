package k23BE.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k23BE.Bookstore.domain.Book;
import k23BE.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	
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
		return "newBook";
	}
	
	@GetMapping("delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		bookRepository.deleteById(id);
		return "redirect:/booklist";
	}
	
	@PostMapping("saveBook")
	public String saveBook(Book book, Model model) {
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
}
