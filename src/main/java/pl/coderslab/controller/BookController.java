package pl.coderslab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.beans.Book;
import pl.coderslab.beans.MemoryBookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	MemoryBookService memoryBookService;

	// @RequestMapping("/hello")
	// @ResponseBody
	// public String hello() {
	// return "hello";
	// }

	@PostMapping("/books/{id}/{isbn}/{title}/{author}/{publisher}/{type}")
	public String createBook(@PathVariable long id, @PathVariable String isbn, @PathVariable String title,
			@PathVariable String author, @PathVariable String publisher, @PathVariable String type) {

		List<Book> listOfBooks = memoryBookService.getList();
		listOfBooks.add(new Book(id, isbn, title, author, publisher, type));

		return "Nowa lista ksiązek";
	}

	@GetMapping("/books/{id}")
	public String showBook(@PathVariable long id) {
		Book book = memoryBookService.getBook(id);
		return "book by id :" + book;
	}

	@GetMapping("/delete/{id}")
	public long deleteBook(@PathVariable long id) {
		Book book = memoryBookService.deleteBook(id);
		return id;
	}

	@GetMapping("/allBooks")
	public String listOfBooks() {
		List<Book> listOfBooks = new ArrayList<Book>();
		listOfBooks = memoryBookService.getList();
		return "list of Books :" + listOfBooks;
	}

}