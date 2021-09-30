package com.BookStore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BookStore.domain.Book;
import com.BookStore.domain.BookRepository;

@RestController
public class ListControllerRest {
	
	@Autowired
	private BookRepository bookRepo;
	
	@RequestMapping(value = "/booklistRest", method = RequestMethod.GET)
	
	public @ResponseBody List<Book> listControllerRest(Model model) {
		model.addAttribute("books", bookRepo.findAll());
		return (List<Book>) bookRepo.findAll();
	}
}
