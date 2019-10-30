package com.pramati.crs.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramati.crs.entities.Customer;
import com.pramati.crs.exceptions.CustomerNotFoundException;
import com.pramati.crs.profiles.dto.CustomerDTO;
import com.pramati.crs.repository.ICustomerRepository;
import com.pramati.crs.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public void save(CustomerDTO customerDTO) {
		
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);
		customerRepository.save(customer);
		
	}

	@Override
	public List<CustomerDTO> list() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();
		customers.parallelStream().forEach(customer -> {
			CustomerDTO customerDTO = new CustomerDTO();
			BeanUtils.copyProperties(customer, customerDTO);
			customerDTOList.add(customerDTO);
		});
		return customerDTOList;
	}

	@Override
	public CustomerDTO get(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isPresent())
		{
			CustomerDTO customerDTO = new CustomerDTO();
			BeanUtils.copyProperties(customer.get(), customerDTO);
			return customerDTO;
		}
		throw new CustomerNotFoundException("Customer id not found");
	}

}
