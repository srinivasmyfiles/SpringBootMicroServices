package com.vj.converters;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.vj.model.Student;

public class XmlToJava {

	public static void main(String[] args) throws JAXBException {
		File xmlFile = new File("student.xml");
		
		JAXBContext jaxBContext = JAXBContext.newInstance(Student.class);
		Unmarshaller unmarshaller = jaxBContext.createUnmarshaller();
		Student student = (Student) unmarshaller.unmarshal(xmlFile);
		System.out.println(student);

	}

}
