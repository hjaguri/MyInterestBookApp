package com.student.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.spring.beans.CustomerBO;
import com.student.spring.beans.CustomerDTO;
import com.student.spring.dao.ICustomerDao;


@Component("service")
public final class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao dao;

	@Override
	public String calculateSimpleInterest(CustomerDTO dto) throws Exception {
		// calculate simple-interest for the given DTO object
		float si = (dto.getPamt() * dto.getTime() * dto.getRate()) / 100;

		// Create a business object from DTO
		CustomerBO bo = new CustomerBO();
		bo.setCustAddr(dto.getCustAddr());
		bo.setCustName(dto.getCustName());
		bo.setPamt(dto.getPamt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());

		// injecting simple-interest amount for BO
		bo.setInterestAmount(si);

		int count = dao.insert(bo);

		return count == 1 ? "Customer registered succesfully with the intereset amount :: " + si
				: "customer registration failed";
	}
}

