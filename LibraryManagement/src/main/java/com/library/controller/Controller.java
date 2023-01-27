//declaring the package
package com.library.controller;

//importing the packages
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Books;
import com.library.services.BookService;

//declaring the class
@RestController
public class Controller {

	@Autowired
	private BookService bookService;

	// get all books handler
	@GetMapping("/books")
	public ResponseEntity<List<Books>> getBooks() {

		List<Books> list = bookService.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	// get single book handler
	@GetMapping("/books/{id}")
	public ResponseEntity<Books> getBook(@PathVariable("id") int id) {
		Books book = this.bookService.getBookById(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}

	// post book handler
	@PostMapping("/books")
	public ResponseEntity<Books> addBook(@RequestBody Books book) {
		Books b = null;
		try {
			b = this.bookService.addBook(book);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// delete book handler
	@DeleteMapping("/books/{bookid}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookid") int bookid) {
		try {
			this.bookService.deleteBook(bookid);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// update book handler
	@PutMapping("/books/{bookid}")
	public ResponseEntity<Books> updateBook(@RequestBody Books book, @PathVariable("bookid") int bookid) {
		try {
			this.bookService.updateBook(book, bookid);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
