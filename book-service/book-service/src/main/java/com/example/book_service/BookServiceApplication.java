package com.example.book_service;

import com.example.book_service.model.Book;
import com.example.book_service.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication

public class BookServiceApplication implements CommandLineRunner {

	private final BookRepository repository;

	public BookServiceApplication(BookRepository repository) {
		this.repository = repository;
	}
	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1=new Book("Dunyanin gozu",2000,"Robert Jordam","qanun","123");
		Book book2=new Book("Yuzuklerin efendisi",1960,"J.R.R.Tolkien","alinino","12334");
		Book book3=new Book("Harry",1997,"J K Rowling","libraf","12334");
		List<Book> bookList=repository.saveAll(List.of(book1,book2,book3));
		System.out.println(bookList);
	}
}
