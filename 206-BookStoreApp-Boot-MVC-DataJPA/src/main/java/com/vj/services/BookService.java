package com.vj.services;

import java.util.List;

import com.vj.binding.BookBinding;

public interface BookService {

	public boolean save(BookBinding book);
	
	public List<BookBinding> getAllBooks();
}
