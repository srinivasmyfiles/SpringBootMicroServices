package com.vj.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vj.entity.ContactsBookEntity;

//@Repository  //optional as we are extending from CrudRepository
public interface ContactsBookRepo extends CrudRepository<ContactsBookEntity, Serializable>{

	/*
	 for more info visit : https://www.baeldung.com/spring-data-derived-queries
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

	//select * from contactsbook where cont_age>18 and active_switch='Y';
	public Iterable<ContactsBookEntity> findByContactAgeGreaterThanAndActiveSwitchIs(Integer age,String activeSwitch);

}
