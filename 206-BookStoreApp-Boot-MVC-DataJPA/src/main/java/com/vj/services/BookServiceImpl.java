package com.vj.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vj.binding.BookBinding;
import com.vj.entities.BookEntity;
import com.vj.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repo;

	@Override
	public boolean save(BookBinding book) {

		//Convert BookBinding obj to BookEntity obj
		BookEntity entity=new BookEntity();
		//copy BookBinding obj to BookEntity for Insert operation
		BeanUtils.copyProperties(book, entity);
		//inserting to table using Repo
		BookEntity saved = repo.save(entity);
		//returning true if inserted based on BOOKID else false
		return saved.getBookId()!=null;
	}

	@Override
	public List<BookBinding> getAllBooks() {
		//collection of BookBinding objs to collect and return 
		List<BookBinding> listOfBooks=new ArrayList<>();
		
		//retrieve all existing book records
		List<BookEntity> entities = repo.findAll();
		
		//convert BookEntites to BookBinding objs
		entities.forEach(entity->{
			//empty BookBinding obj to copy from entity
			BookBinding book = new BookBinding();
			//copy Entity into BookBinding
			BeanUtils.copyProperties(entity, book );
			//add each BookBinding obj with its own data into Collection
			listOfBooks.add(book);
		});
		//return the List Of BookBinding objs
		return listOfBooks;
	}

}
