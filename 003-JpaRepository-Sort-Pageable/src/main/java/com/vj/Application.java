package com.vj;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.vj.entity.ContactsBookEntity;
import com.vj.repositories.ContactsBookRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(Application.class, args);
		
		//get bean
		ContactsBookRepo bean=ctxt.getBean(ContactsBookRepo.class);
		/*
		//get all records
		List<ContactsBookEntity> entities = bean.findAll();
		for (ContactsBookEntity entity: entities) {
			System.out.println(entity);
		}
		*/
		
		/*	//sort by name *default sort is Ascending , so its optional
		//		List<ContactsBookEntity> entities2 = bean.findAll(Sort.by("contactName").ascending);
			List<ContactsBookEntity> entities2 = bean.findAll(Sort.by("contactName").descending());
			for (ContactsBookEntity entity : entities2) {
				System.out.println(entity);
			}
			*/
		int pageSize = 4;
		int pageNo = 2; //index starts from zero //pageNo comes dynamically from UI
		
		PageRequest pageReq = PageRequest.of(pageNo, pageSize);
		Page<ContactsBookEntity> pageRecords = bean.findAll(pageReq);;
		List<ContactsBookEntity> list = pageRecords.getContent();
		for (ContactsBookEntity entities : list) {
			System.out.println(entities);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		ctxt.close();
	}

}
