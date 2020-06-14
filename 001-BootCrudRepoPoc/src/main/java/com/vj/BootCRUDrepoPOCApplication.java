package com.vj;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vj.entity.ContactsBookEntity;
import com.vj.repositories.ContactsBookRepo;

@SpringBootApplication
public class BootCRUDrepoPOCApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctxt = SpringApplication.run(BootCRUDrepoPOCApplication.class, args);

		/*
		here it will use the implementation class ContactsBookEntity as we passed 
		it to ContactsBookRepo  
		for obj creation using Proxy DP
		 */
		//get bean
		ContactsBookRepo bean = ctxt.getBean(ContactsBookRepo.class);

		//________________________________________________________________________________________________		

		//		System.out.println("-----" + bean.getClass().getName()); //gives instantiated class name

		//________________________________________________________________________________________________		

		/*
		ContactsBookEntity entity = new ContactsBookEntity();
		entity.setContactId(225);
		entity.setContactName("Rani");
		entity.setContactNumber(995123L);
		entity.setContactAge(30);
		entity.setActiveSwitch("N");

		System.out.println(bean.save(entity));
		 */
		//		save(Entity) method will UPDATE the given entity record if PK given is EXIST in the table
		//		if PK given does NOT EXIST, it will INSERT the record

		//________________________________________________________________________________________________		
		/*
				//select * from contactsbook;
				Iterable<ContactsBookEntity> entities = bean.findAll();
				entities.forEach(entity->{
					System.out.println(entity);
				});
		 */

		//________________________________________________________________________________________________		

		/*  //select cont_name,cont_number from contactsbook
		Iterable<Object[]> entities = bean.findAllContactNameAndContactNumber();
			for (Object[] entity : entities) {
				System.out.println(entity[0]+"..."+entity[1]);
			}*/

		//________________________________________________________________________________________________		
		//NOTE : when using Custom Queries method can be anything
		//select * from contactsbook where active_switch='Y' or cont_age between 25 and 75;
		
		/*Iterable<ContactsBookEntity> entities = bean.findAllbyActiveSwitchOrContactAge();
		 for (ContactsBookEntity entity: entities) {
			System.out.println(entity);
		}
		 */
		 //________________________________________________________________________________________________		
		 
//		from ContactsBookEntity where contactName =:name " ;
		 Iterable<ContactsBookEntity> entities = bean.getAllBy("aaa");
		 for (ContactsBookEntity entity: entities) {
			System.out.println(entity);
		}

		//________________________________________________________________________________________________		
		/*

		//select * from contactsbook where cont_name=?;

					ContactsBookEntity entity1 = bean.findByContactName("Vijay");
					System.out.println(entity1);

		//select * from contactsbook where cont_id=?;

					ContactsBookEntity entity2 = bean.findByContactId(333);
					System.out.println(entity2);

		//select * from contactsbook where cont_number=?;

					ContactsBookEntity entity3 = bean.findByContactNumber(555l);
					System.out.println(entity3);
		 */

		/*
		//select * from contactsbook where cont_name=? and cont_num=?;

				ContactsBookEntity entity4 = bean.findByContactNameAndContactNumber("aaa", 111L);
				if(entity4==null)
					System.out.println("No record found with the given data");
				else
					System.out.println(entity4);
		 */

		//________________________________________________________________________________________________		

		/*
		//select * from contactsbook where cont_name=? or cont_number=?;
		List<ContactsBookEntity> entities1 = bean.findByContactNameOrContactNumber("aaa", 222l);
		for (ContactsBookEntity ent: entities1) {
			System.out.println(ent);
		}
		 */

		//________________________________________________________________________________________________		

		/*		

		//select * from contactsbook where cont_name=? or cont_number=?;

				Iterable<ContactsBookEntity> entities2 = bean.findByContactNameOrContactNumber("ccc", 555l);
				for(ContactsBookEntity entity : entities2) { System.out.println(entity); }
		//		entities2.forEach(entity -> { System.out.println(entity); });

		 */

		//________________________________________________________________________________________________		

		/*
				//select * from contactsbook where cont_name like 'v%';
				Iterable<ContactsBookEntity> entities3 = bean.findByContactNameStartsWith("v");
				entities3.forEach(entity -> {  System.out.println(entity);  });
		 */

		//________________________________________________________________________________________________		

		/*
		 //select * from contactsbook where cont_age>18 and active_switch='Y';
		Iterable<ContactsBookEntity> entities4 = bean.findByContactAgeGreaterThanAndActiveSwitchIs(18, "Y");
		entities4.forEach(entity -> { System.out.println(entity);	});

		 */

		//________________________________________________________________________________________________		

		/*
		//delet from contactsbook where cont_id=225;
				bean.deleteById(225);
		 */

		//________________________________________________________________________________________________		

		/*
		  Iterable<ContactsBookEntity> entities = bean.findAll();
		entities.forEach(entity->{
			System.out.println(entity);
		});
		 */

		//________________________________________________________________________________________________		

		/*		Iterable<ContactsBookEntity> entities= bean.findAllById(Arrays.asList(224,455,567,223));
				entities.forEach(entity -> {
					System.out.println(entity);
				});
		 */

		//________________________________________________________________________________________________		

		/*		

				findById(PK) method will return Optional Object if the given PK is found
				if PK not found returns EMPTY optional obj

				Optional<ContactsBookEntity> opt= bean.findById(223);
				if(opt.isPresent()) {
					ContactsBookEntity entity= opt.get();
					System.out.println(entity);
				}
				else {
					System.out.println("Record not available");
				}

		 */

		//________________________________________________________________________________________________		

		ctxt.close();
	}

}
