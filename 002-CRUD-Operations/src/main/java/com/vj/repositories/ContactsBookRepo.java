package com.vj.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.vj.entity.ContactsBookEntity;

//@Repository  //optional as we are extending from CrudRepository
public interface ContactsBookRepo extends JpaRepository<ContactsBookEntity, Serializable>{
	//we can extend from CRUD or JPA repository




	//	insert into springcore.contactsbook values(999,'Rajesh',76767,36,'Y');

	@Transactional
	@Modifying
	@Query(value=" INSERT INTO contactsbook VALUES(:idNum ,:name , :num, :age , :actSwitch)", nativeQuery=true)
	public int insertRecord(Integer idNum, String name, Long num, Integer age, String actSwitch);


	//update contactsbook set cont_name="John" where cont_Id=111;
	@Transactional
	@Modifying
	@Query(" update ContactsBookEntity set contactName=:name where contactId=:id ")
	public void updateNameById(String name, Integer id);

	//	delete from ContactsBookEntity where contactId=:id
	@Transactional
	@Modifying
	@Query(" delete from ContactsBookEntity where contactId=:id")
	public void deleteById(Integer id);

	public ContactsBookEntity findByContactId(Integer contactId);


}
