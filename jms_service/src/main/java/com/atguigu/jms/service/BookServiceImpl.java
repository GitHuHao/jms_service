package com.atguigu.jms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.jms.domain.Book;
import com.atguigu.jms.mapper.BookMapper;

@Service("bookService")@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper bookMapper;
	
	public boolean save(@WebParam(partName="book") Book book) {
		try{
			bookMapper.save(book);
			System.out.println("ws-server: save()");
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try{
			bookMapper.delete(id);
			System.out.println("ws-server: delete()");
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public boolean update(@WebParam Book book) {
		try{
			bookMapper.update(book);
			System.out.println("ws-server: update()");
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public Book getById(int id) {
		System.out.println("ws-server: getById()");
		return bookMapper.getById(id);
	}

	public List<Book> getAll() {
		return bookMapper.getAll();
	}

	public Map<Integer, Book> getMap() {
		Map<Integer,Book> map = new HashMap<>();
		List<Book> books = bookMapper.getAll();
		for(Book book:books){
			map.put(book.getId(), book);
		}
		System.out.println("ws-server: getMap()");
		return map;
	}
}
