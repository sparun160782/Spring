package com.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookshop.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Long> {
	
	@Query("SELECT account FROM Account account WHERE account.username=?")
	public Account getAccountByNameAndPrice(@Param("username") String username);

}
