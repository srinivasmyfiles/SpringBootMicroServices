package com.vj.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@XmlRootElement(name = "AllEmployees")
public class Employees {

	@JsonProperty("All Employees")
	List<Employee> employee= new ArrayList<Employee>();

}
