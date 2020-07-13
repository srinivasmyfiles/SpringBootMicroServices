package com.vj.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
//@JsonIgnoreProperties(value = { "skill", "studentAge" })
//@JsonInclude(value = Include.NON_NULL)
public class Student {

	@JsonProperty("id")
	private Integer studentId;
	@JsonProperty("name")
	private String studentName;
	@JsonProperty("skill")
	private String primarySkill;

	/**
	1. @JsonProperty : To bind field with json key
	
	2. @JsonIgnore : To ignore particular field from JSON
		NOTE: @JsonProperty annotation shoud not be there
	
	3. @JsonIgnoreProperties : To ignore more than one field 
		note : we can add field name or Json Prop name ("age") or  ("studentAge")
	
	4. @JsonInclude : To specifiy which fields should include in json
	 */
	//	@JsonIgnore	
	//	@JsonProperty("age")
	private Integer studentAge;
}
