package pl.coderslab.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class MemoryBookService {
	private List<Book> list;

	public MemoryBookService() {
		list = new ArrayList<Book>();
		list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
		list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.", "Sierra Kathy, Bates Bert", "Helion",
				"programming"));
		list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion",
				"programming"));
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	public Book getBook(long id) {
		List<Book> book = list;

		for (int i = 0; i < book.size(); i++) {
			if (book.get(i).getId() == id) {
				return book.get(i);
			}

		}

		return null;
	}

	public List<Book> createBook(Book book) {
		list.add(book);
		return list;
	}

	public List<Book> editBook(Book book, long id) {

		return null;
	}

	public Book deleteBook(long id) {
		List<Book> book = list;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				list.remove(i);
			}

		}

		return null;
	}

}
