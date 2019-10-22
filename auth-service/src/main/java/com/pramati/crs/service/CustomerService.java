package com.pramati.crs.service;

import com.pramati.crs.vo.UserVo;

public interface CustomerService {

	public abstract void createCustomer(UserVo user) throws Exception;

}
