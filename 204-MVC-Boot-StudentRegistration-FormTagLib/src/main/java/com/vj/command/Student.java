package com.vj.command;

import lombok.Data;

@Data
public class Student {

	private String uname;					//textbox
	private String pwd;						//password
	private String email;					//textbox
	private String phone;					//textbox
	private String gender;					//radio buttons
	private String course;				//select list(DropDownList)
	private String[] timings;		//checkboxes
	
	
}
