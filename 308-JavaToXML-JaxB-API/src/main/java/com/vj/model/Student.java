package com.vj.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

	@XmlElement(name = "sid")
	private Integer studentId;
	@XmlElement(name = "sname")
	private String studentName;
	@XmlElement(name = "scourse")
	private String studentCourse;
	@XmlAttribute(name = "section")
	private String section;
}
