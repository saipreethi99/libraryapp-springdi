package org.dxctraining.service;

import org.dxctraining.entities.Book;

import java.util.List;

public interface IBookService {
	Book findById(String id);

	List<Book> findAll();

	Book updatecost(String id, double cost);

	void add(Book book);

	void delete(String id);

}