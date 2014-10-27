package com.restaurant.client;

import com.restaurant.commoninterfaces.Meal;
import com.restaurant.kitchen.ServiceDeck;

public class OrderItemDispatcher implements Meal{

	private static OrderItemDispatcher dispatcher = new OrderItemDispatcher();
	private static ServiceDeck deck = ServiceDeck.getInstance();

	private OrderItemDispatcher() {
		// TODO Auto-generated constructor stub
	}
	
	public static OrderItemDispatcher getInstance()
	{
		return dispatcher;
	}

	@Override
	public void startMeal(Long id) {
		deck.startMeal(id);
	}

	@Override
	public void stopMeal(Long id) {
		deck.stopMeal(id);
	}

	@Override
	public void addItem(Long tableid, Long itemId, int itemCount) {
		deck.addItem(tableid, itemId, itemCount);
	}

	@Override
	public void cancelItem(Long tableid, Long itemId, int itemCount) {
		deck.cancelItem(tableid, itemId, itemCount);
	}

	@Override
	public void cancelAll(Long tableid) {
		deck.cancelAll(tableid);
	}

}
