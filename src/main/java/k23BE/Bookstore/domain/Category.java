package k23BE.Bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		
		private long id;
		
		private String name;
		
		@JsonIgnore
		@OneToMany(cascade = CascadeType.ALL, mappedBy ="category")
		private List<Book> books;

		public Category() {
			super();
		}
		
		public Category(String name) {
			super();
			this.name = name;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Book> getBooks() {
			return books;
		}

		public void setBooks(List<Book> books) {
			this.books = books;
		}

		@Override
		public String toString() {
			return "Category [id=" + id + ", name=" + name + "]";
		}

		
		
}
