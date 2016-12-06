package com.otr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otr.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
