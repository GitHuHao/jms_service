package com.atguigu.jms.mapper;

import java.util.List;

import com.atguigu.jms.domain.Book;

public interface BookMapper {

	boolean save(Book book);
	boolean delete(int id);
	boolean update(Book book);
	Book getById(int id);
	List<Book> getAll();
	
}
