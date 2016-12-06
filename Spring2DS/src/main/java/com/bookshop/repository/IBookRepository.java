/**
 * 
 */
package com.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookshop.entity.Book;

/**
 * @author SPAR
 *
 */
public interface IBookRepository extends JpaRepository<Book, Long> {
	
	@Query("SELECT book.price FROM Book book WHERE book.isbn=?")
	public int getPriceForBook(@Param("isbn") String isbn);

}
