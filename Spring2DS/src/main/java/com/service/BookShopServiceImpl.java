package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.entity.Account;
import com.bookshop.entity.BookStock;
import com.bookshop.repository.IAccountRepository;
import com.bookshop.repository.IBookRepository;
import com.bookshop.repository.IStockRepository;

@Service
public class BookShopServiceImpl implements BookShopService {
	
	private static final Logger log = LoggerFactory.getLogger(BookShopServiceImpl.class);

	@Autowired
	private IStockRepository stockRepo;
	
	@Autowired
	private IBookRepository bookRepo;
	
	@Autowired
	private IAccountRepository accountRepo;
	
	@Transactional (value = "transactionManager")//(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void purchase(String isbn, String username) /*throws Exception*/ {
		
		int accountBalance = 0;	

		
		int price = bookRepo.getPriceForBook(isbn);
		log.info("Price of the book : "+price);
		
		int stock = stockRepo.getStockByISBN(isbn);
		log.info("Stock of the book : "+stock);
		
		BookStock bookStock= stockRepo.getBookStockByISBN(isbn);
		log.info("BookStock : "+bookStock);
		
		Account account = accountRepo.getAccountByNameAndPrice(username);
		log.info("Before Account Info : "+account);
		
		accountBalance = account.getBalance();
		if(accountBalance>price){
			
			bookStock.setStock(stock-1);
			stockRepo.save(bookStock);
			
			account.setBalance(accountBalance-price);
			accountRepo.save(account);
			log.info("BookStock after update: "+bookStock);
		}
		log.info("After Account Info : "+account);
	
	
		  
		
	}

}
