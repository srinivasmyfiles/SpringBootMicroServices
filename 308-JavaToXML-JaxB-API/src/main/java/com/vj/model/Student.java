package com.vj.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "student")
public class Student {

	private Integer StudentId;
	private String studentName;
	private String studentCourse;
}
