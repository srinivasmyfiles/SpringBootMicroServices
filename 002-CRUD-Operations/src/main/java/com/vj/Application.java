package com.vj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vj.entity.ContactsBookEntity;
import com.vj.repositories.ContactsBookRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(Application.class, args);

		//get bean of target
		ContactsBookRepo bean = ctxt.getBean(ContactsBookRepo.class);

		//	insert into springcore.contactsbook values(999,'Rajesh',76767,36,'Y');
		int count = bean.insertRecord(7717, "Suresh", 23234l, 56, "N");
		if(count!=0)
			System.out.println(bean.findById(1234));
		else
			System.out.println(" No records inserted ");



		//			-------------------------------------------------------------------------

		//updating	
		//		bean.updateNameById("Simran", 111);

		//			-------------------------------------------------------------------------

		//			bean.deleteById(111);



		ctxt.close();


	}

}
