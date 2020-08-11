package org.dxctraining.service;

import org.dxctraining.dao.*;
import org.dxctraining.entities.*;
import org.dxctraining.exceptions.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookDao dao;

	@Override
	public Book findById(String id) {
		checkId(id);
		Book book = dao.findById(id);
		return book;
	}

	@Override
	public List<Book> findAll() {
		List<Book> list = dao.findAll();
		return list;
	}

	@Override
	public Book updatecost(String id, double cost) {
		checkId(id);
		Book book = dao.updatecost(id, cost);
		return book;
	}

	public void checkName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidArgumentException("name cant be null or empty");
		}
	}

	public void checkCost(double cost) {
		Double newcost = cost;
		if (newcost == null) {
			throw new InvalidArgumentException("cost cant be null");
		}
	}

	public void checkBook(Book book) {
		if (book == null) {
			throw new InvalidArgumentException("Book can't be null");
		}

	}

	public void checkId(String id) {
		if (id == null || id.isEmpty()) {
			throw new InvalidArgumentException("Id can't be null or empty");
		}
	}

	@Override
	public void delete(String id) {
		checkId(id);
		dao.delete(id);

	}

	@Override
	public void add(Book book) {
		checkBook(book);
		dao.add(book);

	}

}