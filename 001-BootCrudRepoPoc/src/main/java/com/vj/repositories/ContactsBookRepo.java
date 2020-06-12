package com.vj.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vj.entity.ContactsBookEntity;

//@Repository  //optional as we are extending from CrudRepository
public interface ContactsBookRepo extends CrudRepository<ContactsBookEntity, Serializable>{

	/*

	 What is Selection in DB ?
	-------------------------
	-> The process of retrieving specific rows from table is called as Selection

	-> To work with selection we will use where clause in SQL query

	What is Projection in DB?
	-------------------------
	-> The process of retriving specific columns data from record(s)

	-> By specifying column names in the sql query we can achieve projection

	 for more info visit : https://www.baeldung.com/spring-data-derived-queries

 	Custom Queries :
	---------------
	-> To work with Custom queries in data jpa, programmer will write and give query to data jpa 
		then it will execute our query

	-> To work with custom queries we will use @Query annotation


	 */	

	//select * from contactsbook where cont_id=?;
	public ContactsBookEntity findByContactId(Integer id);
	public ContactsBookEntity findByContactIdIs(Integer id);
	public ContactsBookEntity findByContactIdEquals(Integer id);

	//	_________________________________________________________________________________

	//select * from contactsbook where cont_name=?;
	public ContactsBookEntity findByContactName(String name);
	public ContactsBookEntity findByContactNameIs(String name);
	public ContactsBookEntity findByContactNameEquals(String name);

	//	_________________________________________________________________________________

	//select * from contactsbook where cont_number=?;
	public ContactsBookEntity findByContactNumber(Long num);
	public ContactsBookEntity findByContactNumberIs(Long num);
	public ContactsBookEntity findByContactNumberEquals(Long num);

	//	_________________________________________________________________________________

	//select * from contactsbook where cont_name=? and cont_num=?;
	public ContactsBookEntity findByContactNameAndContactNumber(String name,Long num);

	//	_________________________________________________________________________________

	//select * from contactsbooks where cont_name=? or cont_number=?;
	public Iterable<ContactsBookEntity> findByContactNameOrContactNumber(String name, Long number);
	//	public List<ContactsBookEntity> findByContactNameOrContactNumber(String name, Long number);

	//	_________________________________________________________________________________

	//select * from contactsbook where cont_name like 'v%';
	public Iterable<ContactsBookEntity> findByContactNameStartsWith(String name);

	//	_________________________________________________________________________________

	//select * from contactsbook where cont_age>18 and active_switch='Y';
	public Iterable<ContactsBookEntity> findByContactAgeGreaterThanAndActiveSwitchIs(Integer age,String activeSwitch);

	//	_________________________________________________________________________________

	//select * from contactsbook
	//	@Query(" from ContactsBookEntity ")
	public Iterable<ContactsBookEntity> findAll();

	//	_________________________________________________________________________________

	/*
	 //select cont_name,cont_number from contactsbook
	@Query(" select contactName,contactNumber from ContactsBookEntity ")
	public Object[] findAllContactNameAndContactNumber();

	 */



}
