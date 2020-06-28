package com.vj.service;

import org.springframework.stereotype.Service;

import com.vj.exceptions.InvalidIdException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public Double getPercentageById(String id) {
		if(id.equals("123")) {
			return 85.0;
		}
		else {
			throw new InvalidIdException(" Cannot find the given ID !! ");
		}
	}

	
}
