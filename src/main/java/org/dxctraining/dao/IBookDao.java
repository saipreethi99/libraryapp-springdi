package org.dxctraining.dao;

import java.util.List;

import org.dxctraining.entities.*;

public interface IBookDao {

	Book findById(String id);

	List<Book> findAll();

	Book updatecost(String id, double cost);
	
	void add(Book book);

	void delete(String id);


}