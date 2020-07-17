package com.vj.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vj.pojos.Employee;
import com.vj.pojos.Employees;

@RestController
public class EmmployeeController {
	/**
	 * This resource method returns JSON data of an employee based on PathVaribale value
	 * > http://localhost:2525/employee/201
	 * > http://localhost:2525/employee/101
	 * 
	 * Execution Flow :
	 * 1. Client sends request to server with URL along with PathVariable empId.
	 * 2. FrontController (DS) captures that request and gives the URL to HandlerMapper.
	 * 3. HandlerMapper will look for the respective Controller that can process this 
	 * 	  request based on URL and PathVariable.
	 * 4. Then handlerMapper returns the BeanID of that controller to DS.
	 * 5. Contoller processes that request with the respective Resource Method and
	 * 	  returns the data to DS as response.
	 * 6. DS takes the response data and handovers to Http Msg Converter.
	 * 7. Http Msg Converter converts the data to JSON and returns to DS depending 
	 * 	  on the "produces" attribute of Resource Method value. 
	 * 	  Note1 : In this @RestController, its default return is Raw JSON data. 
	 * 	  Note2 : In a REGULAR @Controller, then the returned data will be Logical View Name.  
	 * 8. Finally, DS takes the response data in JSON format and gives it to Client.
	 * 
	 * @param employeeId
	 * @return
	 */
	@GetMapping(value = { "/employee/{empId}" }, produces = { "application/json", "application/xml" })
	public Employee getEmployee(@PathVariable("empId") Integer employeeId) {

		Employee e1 = new Employee();
		e1.setEmployeeId(101);
		e1.setEmployeeName("Pavan");
		e1.setEmployeeDesg("IT");
		e1.setEmployeeAge(31);

		Employee e2 = new Employee();
		e2.setEmployeeId(201);
		e2.setEmployeeName("Rajesh");
		e2.setEmployeeDesg("Database");
		e2.setEmployeeAge(28);

		if (employeeId == 101)
			return e1;
		else if (employeeId == 201)
			return e2;
		else
			return null;
	}

	/**
	 * This resource method returns JSON data with array of Objects
	 * > http://localhost:2525/employees
	 * 
	 * 
	 * > @JsonProperty
	 * > @JsonIgnore
	 * > @JsonIgnoreProperties
	 * > @JsonInclude
	 * 
	 * 1. All these annotations are optional to use based  on requirement.
	 * 2. Resource method will return JSON data without these annotations too, but
	 *    the property names will be taken as Json Data keys.
	 *    
	 * 
	 */

	@GetMapping(value = { "/employees" }, produces = { "application/json", "application/xml" })
	public Employees getAllEmployees() {

		List<Employee> empList = new ArrayList<Employee>();

		Employee e1 = new Employee();
		e1.setEmployeeId(101);
		e1.setEmployeeName("Pavan");
		e1.setEmployeeDesg("IT");
		e1.setEmployeeAge(31);

		Employee e2 = new Employee();
		e2.setEmployeeId(201);
		e2.setEmployeeName("Rajesh");
		e2.setEmployeeDesg("Database");
		e2.setEmployeeAge(28);

		Employee e3 = new Employee();
		e3.setEmployeeId(301);
		e3.setEmployeeName("Vijay");
		e3.setEmployeeDesg("FullStackDev");
		e3.setEmployeeAge(26);

		empList.add(e1);
		empList.add(e2);
		empList.add(e3);

		Employees employees = new Employees();
		employees.setEmployee(empList);

		return employees;

	}
}

/*
In Rest Controller, How to return response in Multiple Formats?
-------------------------------------------------------
To represent response formats in Rest Controller method we will use produces concept.

@GetMapping(
value="/student/{sid}',
produces = {
     "application/json",
     "application/xml"
}
)
public Student getStudentById(Integer sid){
//logic
return studentObj;
}
-------------------------------------------

When method is supporting for multiple response formats like above
 then clients can choose response format using 'Accept' header.
*/