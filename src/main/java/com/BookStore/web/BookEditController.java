package com.BookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.BookStore.domain.Book;
import com.BookStore.domain.BookRepository;
import com.BookStore.domain.CategoryRepository;

@Controller
public class BookEditController {
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	CategoryRepository categoryRepo;

	@GetMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") long id, Model model) {
		model.addAttribute("book", bookRepo.findById(id));
		model.addAttribute("categories", categoryRepo.findAll());
		return ("/editBook");
	}

	@PostMapping(value = "/postedit")
	public String editBookPost(@ModelAttribute Book book, Model model) {
		bookRepo.save(book);
		return "redirect:/booklist";
	}
}