package k23BE.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message = "Name cannot be empty.")
	@Size(min = 3, max = 100)
	private String title;
	@NotEmpty(message = "Name cannot be empty.")
	@Size(min = 3, max = 100)
	private String author;
	private String isbn;
	private double price;
	private int publicationYear;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="categoryid")
	private Category category;
	
	public Book() {
		super();
	}

	public Book(String title, String author, String isbn, double price, int publicationYear, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.publicationYear = publicationYear;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price
				+ ", publicationYear=" + publicationYear + ", category=" + category + "]";
	}


	


}
