package k23BE.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k23BE.Bookstore.domain.Book;
import k23BE.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstore(BookRepository bookRepository) {
		return (args)  -> {
			log.info("create books");
		 //	public Book(String title, String author, String isbn, double price, int year)
			bookRepository.save(new Book("Uusi Tietokirja","Erkki Esimerkki","asdasd", 12.0, 2022));
			bookRepository.save(new Book("Vanha Dekkari","Maija Mainio","fdfsd",15, 2009));
			
			log.info("fetch all the books from the database");
			for (Book book : bookRepository.findAll()) {
				System.out.println("kirja: " + book.toString());
			}
		};
	}
}

