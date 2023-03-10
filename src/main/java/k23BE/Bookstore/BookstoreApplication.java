package k23BE.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k23BE.Bookstore.domain.AppUser;
import k23BE.Bookstore.domain.AppUserRepository;
import k23BE.Bookstore.domain.Book;
import k23BE.Bookstore.domain.BookRepository;
import k23BE.Bookstore.domain.Category;
import k23BE.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstore(BookRepository bookRepository, CategoryRepository categoryRepository, AppUserRepository urepository) {
		return (args)  -> {
			log.info("create categories");
			categoryRepository.save(new Category("Sci-fi"));
			categoryRepository.save(new Category("Nonfiction"));
			
			log.info("create books");
		 //	public Book(String title, String author, String isbn, double price, int year)
			bookRepository.save(new Book("Uusi Tietokirja","Erkki Esimerkki","asdasd", 12.0, 2022, categoryRepository.findByName("Nonfiction").get(0)));
			bookRepository.save(new Book("Vanha Dekkari","Maija Mainio","fdfsd",15, 2009, categoryRepository.findByName("Sci-fi").get(0)));
			
			// Create users: admin/admin user/user
			AppUser user1 = new AppUser("user", "$2a$10$5Iciwn.H7msc3WyUisYgveFx3sBHkF5vnp5psZpqfUbMI5OjznWru", "USER", "www.user@app.com");
			AppUser user2 = new AppUser("admin", "$2a$10$QFZyn3zccxogPDFW0zbxa.E7mRDnW7r4.hAA/fA5ceqYEq3LdaPZq", "ADMIN", "www.admin@app.com");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all the books from the database");
			for (Book book : bookRepository.findAll()) {
				System.out.println("kirja: " + book.toString());
			}
		};
	}
}

