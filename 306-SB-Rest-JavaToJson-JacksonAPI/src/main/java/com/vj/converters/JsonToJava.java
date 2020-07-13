package com.vj.converters;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vj.pojo.Student;

public class JsonToJava {

	public static void main(String[] args) throws Exception {
		convertJsonToObj();
	}
	
	private static void convertJsonToObj() throws Exception{
		File f = new File("src/main/resources/students.json");
		ObjectMapper mapper = new ObjectMapper();
		Student student = mapper.readValue(f, Student.class);
		System.out.println(student);
}
}
