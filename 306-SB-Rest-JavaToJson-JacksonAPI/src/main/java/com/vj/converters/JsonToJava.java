package com.vj.converters;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vj.pojo.Student;

public class JsonToJava {

	public static void main(String[] args) throws Exception {

		System.out.println(" Json data to One object");
		convertJsonToObj();

		System.out.println("\n\n Json data to Array of objects");
		convertJsonDataToObj();
	}

	private static void convertJsonToObj() throws Exception {
		File f = new File("student.json");
		ObjectMapper mapper = new ObjectMapper();
		Student student = mapper.readValue(f, Student.class);
		System.out.println(student);
	}

	private static void convertJsonDataToObj() throws Exception {
		File f = new File("students.json");
		ObjectMapper mapper = new ObjectMapper();
		Student[] students = mapper.readValue(f, Student[].class);
		for (Student student : students) {
			System.out.println(student);
		}

	}
}
