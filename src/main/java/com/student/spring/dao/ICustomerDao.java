package com.student.spring.dao;

import com.student.spring.beans.CustomerBO;

public interface ICustomerDao {
	public int insert(CustomerBO bo) throws Exception;
}
