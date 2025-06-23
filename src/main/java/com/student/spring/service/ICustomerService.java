package com.student.spring.service;

import com.student.spring.beans.CustomerDTO;

public interface ICustomerService {

	public String calculateSimpleInterest(CustomerDTO dto)throws Exception;
	
}
