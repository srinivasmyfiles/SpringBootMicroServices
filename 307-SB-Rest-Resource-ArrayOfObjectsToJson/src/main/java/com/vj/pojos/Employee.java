package com.vj.pojos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Employee {

	@XmlElement(name = "eid")
	@JsonProperty("id")
	private Integer employeeId;
	@XmlElement(name = "ename")
	@JsonProperty("name")
	private String employeeName;
	@XmlElement(name = "edesg")
	@JsonProperty("desg")
	private String employeeDesg;
	@XmlElement(name = "eage")
	@JsonProperty("age")
	private Integer employeeAge;
}
