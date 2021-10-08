package com.BookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BookStore.domain.BookRepository;
import com.BookStore.domain.CategoryRepository;
import com.BookStore.domain.UserRepository;

@Controller
public class ListController {

	@Autowired
	private BookRepository bookRepo;
	@Autowired
	CategoryRepository categoryRepo;
	@Autowired
	UserRepository userRepo;

	@RequestMapping(value = "/booklist")
	public String listController(Model model) {
		model.addAttribute("books", bookRepo.findAll());
		return "booklist";
	}
}