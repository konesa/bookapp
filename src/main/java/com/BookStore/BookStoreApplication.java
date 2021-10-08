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
import com.BookStore.domain.UserRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class);
	}

	@Autowired
	BookRepository bookRepo;
	@Autowired
	CategoryRepository categoryRepo;
	@Autowired
	UserRepository userRepo;

	@Bean
	public CommandLineRunner commandLineRunner() {
		return (args) -> {
			categoryRepo
					.saveAll(List.of(
					new Category(1, "Tragedy"), new Category(2, "Comedy"), new Category(3, "Horror")));
			bookRepo.saveAll(List.of(
					new Book("Incredible", "Asimov", 2021, "132456789", 49.99, categoryRepo.findById((long) 1).get()),
					new Book("Marvelous", "Dude", 2021, "456123789", 49.99, categoryRepo.findById((long) 2).get())));
			userRepo.saveAll(List.of(
					new com.BookStore.domain.User(1, "user",
							"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "email", "USER"),
					new com.BookStore.domain.User(2, "admin",
							"$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","email", "ADMIN")));
		};
	};
}