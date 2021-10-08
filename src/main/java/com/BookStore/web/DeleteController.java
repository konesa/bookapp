package com.BookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.BookStore.domain.BookRepository;

@Controller
public class DeleteController {
	@Autowired BookRepository bookRepo;
	@RequestMapping(value ="/delete{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	
	public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
		bookRepo.deleteById(bookId);
		return "redirect:../booklist";
	}
}