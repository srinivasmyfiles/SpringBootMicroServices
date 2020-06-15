package com.vj.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vj.entity.ContactsBookEntity;

//@Repository  //optional as we are extending from CrudRepository
public interface ContactsBookRepo extends JpaRepository<ContactsBookEntity, Serializable>{
	/*
		JpaRepository(I) have access to 30 methods
		11 of its own, 11 of CrudRepository(I), 2 of PageableAndSortingRepository(I)
		6 of QueryByExecutor(I)

	 */	

	/*
	findAll method can be called in 3 ways
	1. public List<T>  findAll();		//retrives all records
	2. public List<T>  findAll(Sort sort);	//retrieves all records by given property sort
	3. public List<T>findAll(Pageble); //retrive records based on page
	 */
	public List<ContactsBookEntity>  findAll();







}
