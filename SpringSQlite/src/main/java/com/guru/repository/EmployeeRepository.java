package com.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guru.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	/*@Query("SELECT bookStock.stock FROM BookStock bookStock WHERE bookStock.isbn=?")
	public int getStockByISBN(@Param("isbn") String isbn);
	
	@Query("SELECT bookStock FROM BookStock bookStock WHERE bookStock.isbn=?")
	public BookStock getBookStockByISBN(@Param("isbn") String isbn);*/
	

}
