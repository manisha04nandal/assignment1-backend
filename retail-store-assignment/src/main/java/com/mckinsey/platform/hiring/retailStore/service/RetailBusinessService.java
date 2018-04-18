package main.java.com.mckinsey.platform.hiring.retailStore.service;

import java.util.List;

import main.java.com.mckinsey.platform.hiring.retailStore.Item;
import main.java.com.mckinsey.platform.hiring.retailStore.model.User;

/**
 * This interface contains API for retail store bill generation
 * @author manisha nandal
 *
 */
public interface RetailBusinessService {
	
	double getNetPayableAmount(List<Item> items, User user);

}
