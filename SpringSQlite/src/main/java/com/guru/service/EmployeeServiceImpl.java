package com.guru.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.guru.entity.Employee;
import com.guru.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Inject
	EmployeeRepository employeeRepo;
	
	@Override
	public Employee fetchEmployee(long id) {
		
		Employee emp = new Employee();
		emp.setEmpName("Hello");
		
		/*Employee emp = new Employee();
		employeeRepo.findOne(1);*/
		
		
		List<Employee> employees = employeeRepo.findAll();
		System.out.println("Employees :: "+employees);
		/*for (Employee employee : employees) {
			System.out.println(employee.getEmpId() + "Emp Name :: "+ employee.getEmpName());
		}*/
		
		
		//employeeRepo.save(emp);
		
		return emp;
		
		
	}
	

}
