package com.BookStore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.BookStore.domain.Book;
import com.BookStore.domain.BookRepository;
import com.BookStore.domain.Category;
import com.BookStore.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class);
	}

	@Autowired
	BookRepository bookRepo;
	@Autowired
	CategoryRepository categoryRepo;
	
	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			categoryRepo.saveAll(List.of(new Category(1, "Tragedy"), new Category(2, "Comedy"), new Category(3, "Horror")));
		bookRepo.saveAll(List.of(
				new Book("Incredible", "Asimov", 2021,"132456789", 49.99, categoryRepo.findById((long)1).get()),
				new Book("Marvelous", "Dude", 2021,"456123789", 49.99, categoryRepo.findById((long)2).get())));
		};
	};
}