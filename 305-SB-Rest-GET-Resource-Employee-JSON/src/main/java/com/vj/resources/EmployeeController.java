package com.vj.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vj.model.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	/**
	 * > Taking Object as return type of Rest Resource method.
	 * > By default this method return response as Raw data in JSON format.
	 * > We have an attribute "produces" to mention the response format in JSON.(Optional)
	 * > The conversion of Java Obj to JSON data is done by DS using "Jackson API" 
	 * 		integrated in Spring Rest API.
	 * > "produces" attribute of GetMapping can be used to specify the format of 
	 * 		Raw Response that the client want. 
	 * @param empId
	 * @return
	 */
	@GetMapping(value = "/id/{eid}", produces = "application/json")
	public Employee getStudentResource(@PathVariable("eid") Integer empId) {

		Employee e = new Employee();
		if (empId == 111) {
			e.setEmployeeId(111);
			e.setEmployeeName("Miller");
			e.setEmployeeDesg("Manager");
		} else if (empId == 222) {
			e.setEmployeeId(222);
			e.setEmployeeName("Priya");
			e.setEmployeeDesg("CEO");
		}
		return e;
	}
}

/**
  RESTful Services / Spring REST / REST API :
 
 > 	Resource and Client : These terms are used in REST API / RestFul Services to represent 
  						  a RestAPI resource / Client components.
  
    - Resource :   (Resource will provide business services to other applications)
    			   An application component that provides service to 
                   other application component can be called as Resource.
                   e.g. This Employee Resource Component, A distributed REST API etc.
                   
  	- Client   : (Client will access services from other applications)
  				 An application component that uses the services provided by other (Resource)
  				 application component is called as Client.
 ____________________________________________________________________________________________
 
   JAX-RS / RestServices / XML RS :
   
   > Producer and Consumer : There terms are used in JAX - RS API to represent a
   							 REST components.
   
   - Producer : The application which is providing business services to other applications
                is called as a Provider application.
   
   - Consumer : The application which is accessing business services from other applications
                is called as Consumer application.
   				
 ____________________________________________________________________________________________
  Rest components
---------------
1) Resource
2) Client
3) XML / Json / TEXT / Yml 
4) WADL / Swagger
5) Postman


-> Roy Fielding provided REST Architecture principle (Same principles already using by Internet)

-> Sun MicroSystems also supported for Roy Fielding principles and released one API into market 
 					i.e JAX-RS API.

-> JAX-RS stands for Java API for XML- Restful services

Note: APIs are always partial. They contains set of interfaces & abstract classes.

We can't use API directly to develop a project. We need implementation for API to develop project.

What are the implementations available for JAX-RS API?
-------------------------------------------------
1) Jersey  (Sun)

2) Rest Easy  (JBOSS)

Note: Both Jersey & REST Easy implementations supports for REST Resource development & REST Client development.

By using Spring with REST concept we can develop RESTful services using framework.

We can develop RESTful services using Spring mvc module.

Note: Spring Web MVC jars are sufficient to develop RESTful services (additional jars are not required)

 _________________________________________________________________________________
 REST Architecture Principles
----------------------------
checkout : https://ninenines.eu/docs/en/cowboy/2.8/guide/rest_principles/

1) Unique Address

2) Uniform Constraint Interfaces

3) Media Representation

4) Communication Stateless

5) HATEOS

1. What is Unique Address?
-----------------------
   - Every Distributed Component operation should have unique address.

2. What is uniform constraint interfaces?
--------------------------------------
   - The main aim of This principle to provide easy adoptability.

   - To achieve this we will bind our resource methods to http protocol methods

3. Media Representation
--------------------
   - The main aim of this principle to provide 100% intereoperability

   - RESTful services will support for multiple fromats of data to exchange between client and resource.

4. Communication stateless
-------------------------
   - That means the communication between the client and the server always contains all 
     the information needed to perform the request. There is no session state in the server, 
     it is kept entirely on the client's side. 
   
   
5. HATEOs ( Hypermedia as the engine of application state)
 
 	Response in any format.

 	To give a simple example, if your service only works with the 
 	application/json media type then this constraint cannot be respected 
 	(as there are no concept of links in JSON) and thus your service isn't RESTful. 
 	This is the case for the majority of self-proclaimed REST services.
 
 
 */
