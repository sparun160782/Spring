/**
 * 
 */
package com.service;

import java.util.List;

/**
 * @author z004408
 *
 */
public interface Cashier {
	
	public void checkout(List<String> isbn, String username);
}
