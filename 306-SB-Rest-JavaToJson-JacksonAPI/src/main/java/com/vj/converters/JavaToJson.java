package com.vj.converters;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vj.pojo.Student;

public class JavaToJson {

	/**
	 * 2 Dependencies we added : Project Lombok and Jackson API.
	 * 
	 * 1. ObjectMapper mapper = new ObjectMapper();
	 * 2. String jsonString = mapper.writeValueAsString(s);
	 * 
	 * These are the two lines executed internally by Dispatcher Servlet,
	 * to convert Java Object to Json data using Http Message Converters(jackson API).
	 * _____________________________________________________________________________
	 * 
	 * What is the difference between Jackson ans Json?
	  > Jackson is an API.
	  > Json is a Parser. (Universal)
	 * 
	 * 
	 * ______________________________________________________________________________
	 * Json
		----
		-> Java Script Object Notation
	
		-> It is light weight when compared with xml
	
		-> Now a days it is the defacto standard to exchange data over a network.
	
		-> Json will represent data in key value format
	
		syntax:
		-------
		{
		"student-id" : 101,
		"student-name" : "Raju",
		"student-skill" : "Java
		}
		
		-> While working with REST API development we will deal with JSON data 
			for both Input and Ouput.
	
		How JSON data can be used in Java Applications
		----------------------------------------------
		-> To work with JSON data we have Jackson API
	
		-> Jackson API is JSON Processor For Java
	
		-> Using Jackson, we can convert java object to json and json data to java object.
	
		Note:JSON is universal format, where as Jackson is java specific api.
	
		-> Every programming language will have their own apis to deal with JSON data.
	 * 
	 * 
	 */

	public static void main(String[] args) throws JsonProcessingException {

		convertJavaToJson();
		convertJavaObjectsToJson();

	}

	private static void convertJavaToJson() throws JsonProcessingException {
		Student s = new Student();

		s.setStudentId(101);
		s.setStudentName("Vijay");
		s.setPrimarySkill("FullStackDeveloper");
		//		s.setStudentAge(25);

		System.out.println(" One Object");
		System.out.println("Java Format : " + s);

		//		Convert Java Obj to Json format using Jackson API
		ObjectMapper mapper = new ObjectMapper();
		//		convert Object to String Json Format
		String jsonString = mapper.writeValueAsString(s);

		//		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(s);		

		System.out.println("Json Format : " + jsonString);
	}

	private static void convertJavaObjectsToJson() throws JsonProcessingException {

		Student s1 = new Student();
		s1.setStudentId(101);
		s1.setStudentName("Vijay");
		s1.setPrimarySkill("FullStackDeveloper");
		//		s1.setStudentAge(18);

		Student s2 = new Student();
		s2.setStudentId(201);
		s2.setStudentName("Pavan");
		s2.setPrimarySkill("Tech");
		s2.setStudentAge(29);

		List<Student> studList = new ArrayList<Student>();
		studList.add(s1);
		studList.add(s2);

		System.out.println("\n\n\n Array of Objects");
		System.out.println("Java Format : " + studList);

		//		Convert Java Obj to Json format using Jackson API
		ObjectMapper mapper = new ObjectMapper();
		//		convert Object to String Json Format
		String jsonString = mapper.writeValueAsString(studList);

		//writerWithDefaultPrettyPrinter() : to format JSON into lines like format_sql=true
		//		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(s);		

		System.out.println("Json Format : " + jsonString);
	}

}
