package com.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookshop.entity.BookStock;

public interface IStockRepository extends JpaRepository<BookStock, Long> {
	
	@Query("SELECT bookStock.stock FROM BookStock bookStock WHERE bookStock.isbn=?")
	public int getStockByISBN(@Param("isbn") String isbn);
	
	@Query("SELECT bookStock FROM BookStock bookStock WHERE bookStock.isbn=?")
	public BookStock getBookStockByISBN(@Param("isbn") String isbn);
	

}
