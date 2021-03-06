package com.iphone567.shop;

public class BookDAO {
	private Book[] books = new Book[4];
	{
		books[0] = new Book("1", "西游记", "吴承恩");
		books[1] = new Book("2", "红楼梦", "曹雪芹");
		books[2] = new Book("3", "三国演义", "罗贯中");
		books[3] = new Book("4", "水浒传", "施耐庵");
	}

	public Book findBookById(String id) {
		for (int i = 0; i < books.length; i++) {
			Book book = books[i];
			if (book.getId().equals(id)) {
				return book;
			}
		}
		return null;
	}

	public Book[] findAllBooks() {
		return this.books;
	}
}
