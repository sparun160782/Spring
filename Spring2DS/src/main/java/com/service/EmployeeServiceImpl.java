/**
 * 
 */
package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otr.entity.Employee;
import com.otr.repository.EmployeeRepository;

/**
 * @author z004408
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
		
	@Override
	public List<Employee> getEmployees() {
		
		List<Employee> empList = employeeRepository.findAll();
		log.info("empList : "+empList);		
		
		return empList;
	}

}
