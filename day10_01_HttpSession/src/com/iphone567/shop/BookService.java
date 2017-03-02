package com.iphone567.shop;

public class BookService {
	private BookDAO dao = new BookDAO();

	public Book findBookById(String id) {
		return dao.findBookById(id);
	}

	public Book[] findAllBooks() {
		return dao.findAllBooks();
	}

}
