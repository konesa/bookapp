package com.BookStore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BookStore.domain.Book;
import com.BookStore.domain.BookRepository;

@RestController
public class getBookByIdRestController {

	@Autowired
	private BookRepository bookRepo;

	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)

	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return bookRepo.findById(bookId);
	}
}