package org.dxctraining.dao;

import org.dxctraining.entities.*;
import org.dxctraining.exceptions.*;
import java.util.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements IBookDao {
	private Map<String, Book> store = BookStore.getstore();
	
	private int generatedid;

	public String generatedId() {
		generatedid++;
		String stringid = "" + generatedid;
		return stringid;
	}

	@Override
	public Book findById(String id) {
		Book book = store.get(id);
		if (book == null) {
			throw new BookNotFoundException("Book not found for id=" + id);
		}
		return book;
	}

	@Override
	public List<Book> findAll() {
		Collection<Book> value = store.values();
		List<Book> list = new ArrayList<>();
		for (Book books : value) {
			list.add(books);
		}
		return list;
	}

	@Override
	public void add(Book book) {
		String id = generatedId();
		store.put(id, book);
		book.setId(id);
	}

	@Override
	public Book updatecost(String id, double cost) {
		Book book = findById(id);
		book.setCost(cost);
		return book;
	}

	@Override
	public void delete(String id) {
		store.remove(id);
	}

}