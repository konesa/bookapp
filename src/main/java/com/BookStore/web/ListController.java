package com.BookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.BookStore.domain.BookRepository;
import com.BookStore.domain.CategoryRepository;

@Controller
public class ListController {

	@Autowired
	private BookRepository bookRepo;
	@Autowired
	CategoryRepository categoryRepo;

	@RequestMapping(value = "/booklist")
	public String listController(Model model) {
		model.addAttribute("books", bookRepo.findAll());
		return "booklist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		bookRepo.deleteById(id);
		return "redirect:/booklist";
	}
}