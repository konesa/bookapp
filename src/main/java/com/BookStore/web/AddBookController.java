package com.BookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.BookStore.domain.Book;
import com.BookStore.domain.BookRepository;
import com.BookStore.domain.CategoryRepository;

@Controller

public class AddBookController {
	@Autowired
	BookRepository bookRepo;
	@Autowired
	CategoryRepository categoryRepo;

	@GetMapping(value = "/addBook")
	public String addBookGetController(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepo.findAll());
		return "addBook";
	}

	@PostMapping(value = "/addBook")
	public String addBookPostController(@ModelAttribute Book book, Model model) {
		System.out.println(model.toString());
		bookRepo.save(book);
		return "redirect:/booklist";
	}
}