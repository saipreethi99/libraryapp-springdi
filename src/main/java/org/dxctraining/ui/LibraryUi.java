package org.dxctraining.ui;

import org.dxctraining.JavaConfig;
import org.dxctraining.entities.*;
import org.dxctraining.service.*;
import org.dxctraining.exceptions.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
@Component
public class LibraryUi {
	
	@PostConstruct
	private IBookService bookservice;

	private void runapp() {
		try {
			Author author1 = new Author("5", "preethi");
			Author author2 = new Author("6", "isu");
			Author author3 = new Author("7", "chinnu");
			Author author4 = new Author("8", "sai");

			Book book1 = new Book("c", 400.0, author1);
			Book book2 = new Book(" c++", 500.2, author2);
			Book book3 = new Book("java", 600.3, author3);
			Book book4 = new Book("java", 700.4, author4);

			bookservice.add(book1);
			bookservice.add(book2);
			bookservice.add(book3);
			bookservice.add(book4);
			displayAll();
		} catch (InvalidArgumentException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		catch (BookNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		catch (AuthorNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		catch (BookCostException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("some thing went wrong");
		}

	}

	private void displayAll() {
		List<Book> list = bookservice.findAll();
		for (Book book : list) {
			display(book);
		}

	}

	private void display(Book book) {
		System.out.println("****display books details***");
		Author author = book.getAuthor();
		System.out.println("id " + author.getId() + "The author is " + author.getName() + "bookid " + book.getId()
				+ " bookname" + book.getName() + " The cost " + book.getCost() + "");
	}

}