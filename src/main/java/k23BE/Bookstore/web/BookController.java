package k23BE.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
	
	@GetMapping(value = "/index")
	@ResponseBody
	public String showIndexPage() {
	return "This is index page";
	}
	
}
