package com.atguigu.jms.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.atguigu.jms.domain.Book;

public interface BookService {

	boolean save(Book book);
	boolean delete(int id);
	boolean update(Book book);
	Book getById(int id);
	List<Book> getAll();
	Map<Integer,Book> getMap();
}
