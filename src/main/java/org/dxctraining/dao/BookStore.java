package org.dxctraining.dao;

import java.util.*;

import org.dxctraining.entities.*;

public class BookStore {
	
	private static Map<String, Book> store = new HashMap<>();
	
	public static Map<String, Book> getstore() {
		return store;
	}

}
