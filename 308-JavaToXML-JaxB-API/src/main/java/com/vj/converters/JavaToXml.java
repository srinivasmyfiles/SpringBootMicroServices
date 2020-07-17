package com.vj.converters;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.vj.model.Student;

public class JavaToXml {

	public static void main(String[] args) throws Exception {

		Student s = new Student();
		s.setStudentId(101);
		s.setStudentName("Manish");
		s.setStudentCourse("Java");
		s.setSection("a");
		JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// to print on console
		marshaller.marshal(s, System.out);

		// to write xml to a file
		marshaller.marshal(s, new FileOutputStream(new File("student.xml")));
	}

}
