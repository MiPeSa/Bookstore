package k23BE.Bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title, author, isbn;
	private double price;
	
	@Column(name="publication_year")
	private int publicationYear;
	
	public Book() {
		super();
	}
	
	public Book(String title, String author, String isbn, double price, int year) {
		super();	
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.publicationYear = year;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getYear() {
		return publicationYear;
	}
	public void setYear(int year) {
		this.publicationYear = year;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price
				+ ", publicationYear=" + publicationYear + "]";
	}


}
