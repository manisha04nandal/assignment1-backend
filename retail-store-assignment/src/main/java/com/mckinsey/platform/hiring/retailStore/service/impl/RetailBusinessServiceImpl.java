package main.java.com.mckinsey.platform.hiring.retailStore.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import main.java.com.mckinsey.platform.hiring.retailStore.Item;
import main.java.com.mckinsey.platform.hiring.retailStore.model.User;
import main.java.com.mckinsey.platform.hiring.retailStore.model.UserType;
import main.java.com.mckinsey.platform.hiring.retailStore.service.RetailBusinessService;

/**
 * This class contaiins api implementation for retail business
 * @author manisha nandal
 *
 */
@Service
public class RetailBusinessServiceImpl implements RetailBusinessService {

	@Override
	public double getNetPayableAmount(List<Item> items, User user) {
		
		double totalAmount = 0.0;
		double discountValue = UserType.getDiscount(user.getUserType(), user.getRegisteredOn());
		List<Item> groceryItems = items.stream().filter(item -> item.getCategory().equals("grocery")).collect(Collectors.toList());
		
		// sum the price of all the items that are non grocery items
		for(Item item : items) {
			if(groceryItems.contains(item)) {
				// do nothing
			} else {
				totalAmount = totalAmount + item.getPrice() * item.getQuantity();
			}
		}
		// percentage discount subtracted from total
		totalAmount = totalAmount - totalAmount*discountValue;

		// add grocery item price to total amount
		for(Item item : groceryItems) {
			totalAmount = totalAmount + item.getPrice()*item.getQuantity();
		}
		
		// discount on total bill
		totalAmount = totalAmount - Math.floor(totalAmount/100) * 5;
		return totalAmount;
	}
}
