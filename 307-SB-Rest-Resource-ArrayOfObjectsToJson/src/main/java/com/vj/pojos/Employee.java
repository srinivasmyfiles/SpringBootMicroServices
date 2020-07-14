package com.vj.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class Employee {

	@JsonProperty("id")
	private Integer employeeId;
	@JsonProperty("name")
	private String employeeName;
	@JsonProperty("desg")
	private String employeeDesg;
	@JsonProperty("age")
	private Integer employeeAge;
}
