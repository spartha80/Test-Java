package com.restaurant.kitchen;

import java.util.Collection;
import java.util.HashMap;

import com.restaurant.commoninterfaces.MenuBuilder;
import com.restaurant.menu.Item;

public class Biller {

	private static Biller biller = new Biller();
	private Biller() {
		// TODO Auto-generated constructor stub
	}
	
	public static Biller getInstance()
	{
		return biller;
	}
	
	public void generateBill(Long tableId, HashMap<Long, Item> table)
	{
		Collection<Item> items = table.values();
		float total = 0;
		for (Item item: items) {
			float itemPrice = item.getCount() * MenuBuilder.getInstance().getPrice(item.getMenuId());
			total += itemPrice;
			System.out.println(item.getMenuId() + " " + MenuBuilder.getInstance().getItemName(item.getMenuId()) + "count: " + item.getCount() + " Price: " + itemPrice);
		}
		System.out.println("Grand Total: " + total);
	}

}
