package com.BookStore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.BookStore.domain.Book;
import com.BookStore.domain.BookRepository;
import com.BookStore.domain.Category;
import com.BookStore.domain.CategoryRepository;
import com.BookStore.domain.User;
import com.BookStore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTests {

	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void findByIdBook() {
		Book book = bookRepo.findById((long) 1).orElse(null);
		assertThat(book.getTitle()).isEqualTo("Incredible");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("mickey", "mouse", 2021, "456123789", 49.99, categoryRepo.findById((long) 2).get());
		bookRepo.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void deleteBook() {
		bookRepo.deleteById((long) 2);
	}

	@Test
	public void findByIdCategory() {
		Category category = categoryRepo.findById((long) 1).orElse(null);
		assertThat(category.getCategoryName()).isEqualTo("Tragedy");
	}

	@Test
	public void createNewCategory() {
		Category category = new Category("My life");
		categoryRepo.save(category);
		assertThat(category.getCategoryId()).isNotNull();
	}

	@Test
	public void deleteCategory() {
		bookRepo.deleteById((long) 2);
	}

	@Test
	public void findByIdUser() {
		User user = userRepo.findById((long) 1).orElse(null);
		assertThat(user.getUsername()).isEqualTo("user");
	}

	@Test
	public void createNewUser() {
		User user = new User("user2", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "email", "USER");
		userRepo.save(user);
		assertThat(user.getId()).isNotNull();
	}

	@Test
	public void deleteUser() {
		userRepo.deleteById((long) 2);
	}
}
