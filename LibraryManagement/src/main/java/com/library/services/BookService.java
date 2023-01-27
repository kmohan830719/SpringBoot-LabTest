//declaring the package
package com.library.services;

//importing the packages
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.entity.Books;
import com.library.repository.BookRepository;

//declaring service class
@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	// get all books
	public List<Books> getAllBooks() {
		List<Books> list = (List<Books>) this.bookRepository.findAll();
		return list;
	}

	// get single book by id
	public Books getBookById(int id) {
		Books book = null;
		try {
			book = this.bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// adding the book
	public Books addBook(Books b) {
		Books result = this.bookRepository.save(b);
		return result;
	}

	// deleting the book
	public void deleteBook(int bid) {
		this.bookRepository.deleteById(bid);
	}

	// updating the book
	public void updateBook(Books book, int id) {
		book.setBoook_id(id);
		this.bookRepository.save(book);
	}
}
