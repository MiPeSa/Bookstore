package k23BE.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k23BE.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	/*@Autowired
	private BookRepository bookRepository;
	*/
	
	@GetMapping(value= "/main")
	public String showMainPage() {
		return "index";
	}
	
	/* @RequestMapping(value = {"/booklist", "/"} )
	public String showBooklist(Model model) {
		model.addAttribute("books", bookRepository.findAll());
			return "booklist";
	} */
	
}
