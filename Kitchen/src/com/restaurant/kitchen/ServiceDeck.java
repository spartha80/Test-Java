package com.restaurant.kitchen;

import java.util.HashMap;

import com.restaurant.commoninterfaces.Meal;
import com.restaurant.menu.Item;

public class ServiceDeck implements Meal{

	private HashMap<Long, HashMap<Long,Item>> tables;
	private static ServiceDeck deck = new ServiceDeck();
	
	public static ServiceDeck getInstance()
	{
		return deck;
	}

	private ServiceDeck() {
	}

	@Override
	public void startMeal(Long id) {
		if (!tables.containsKey(id)) {
			tables.put(id, new HashMap<Long,Item>());
		}
	}

	@Override
	public void stopMeal(Long id) {
		if (tables.containsKey(id)) {
			HashMap<Long,Item> table = tables.remove(id);
			Biller.getInstance().generateBill(id, table);
		}
	}

	@Override
	public void addItem(Long tableId, Long itemId, int itemCount) {
		HashMap<Long,Item> item = tables.get(tableId);
		if (item.containsKey(itemId)) {
			item.put(itemId, new Item(itemId, itemCount));
		} else {
			Item menuItem = item.get(itemId);
			menuItem.setCount(menuItem.getCount() + itemCount);
		}
	}

	@Override
	public void cancelItem(Long tableId, Long itemId, int itemCount) {
		HashMap<Long,Item> items = tables.get(tableId);
		Item menuItem = items.get(itemId);
		if (menuItem.getCount() - itemCount > 0)
			menuItem.setCount(menuItem.getCount() - itemCount);
		else
			items.remove(itemId);
	}

	@Override
	public void cancelAll(Long tableId) {
		if (tables.containsKey(tableId))
			tables.get(tableId).clear();
	}

}
