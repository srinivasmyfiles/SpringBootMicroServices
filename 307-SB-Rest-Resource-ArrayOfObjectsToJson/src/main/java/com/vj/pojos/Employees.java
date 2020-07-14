package com.vj.pojos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Employees {

	@JsonProperty("All Employees")
	List<Employee> employees = new ArrayList<Employee>();

}
