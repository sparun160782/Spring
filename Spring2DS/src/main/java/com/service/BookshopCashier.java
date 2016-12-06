/**
 * 
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author z004408
 *
 */
@Service
public class BookshopCashier implements Cashier {
	
	@Autowired
	private BookShopService bookShopService;
		
	@Transactional (value = "transactionManager")//(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void checkout(List<String> isbn, String username) {
	
		for (String sisbn : isbn) {
			
			bookShopService.purchase(sisbn, username);
			
		}

	}

}
