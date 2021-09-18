package com.BookStore;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.BookStore.domain.Book;
import com.BookStore.domain.BookRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			repository.saveAll(List.of(
					new Book("Philosophy", "Asimov", 2021, "123456789", 20),
					new Book("Incredible", "Jorma", 2021, "321654897", 20),
					new Book("Unbeliavable", "Tsitsipas", 2021, "456789123", 20)));
			for (Book book : repository.findAll()) {
				System.out.println(book.toString());
			}
		};
	}
}