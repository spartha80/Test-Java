package com.restaurant.client;

import com.restaurant.commoninterfaces.Meal;

public class Table implements Meal{

	private Long id;
	private static OrderItemDispatcher orderDispatcher = OrderItemDispatcher.getInstance();
	
	public Table() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public void startMeal(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopMeal(Long id) {
		orderDispatcher.stopMeal(id);
	}

	@Override
	public void addItem(Long tableId, Long itemId, int itemCount) {
		orderDispatcher.addItem(tableId, itemId, itemCount);
	}

	@Override
	public void cancelItem(Long tableId, Long itemId, int itemCount) {
		orderDispatcher.cancelItem(tableId, itemId, itemCount);
	}

	@Override
	public void cancelAll(Long tableId) {
		orderDispatcher.cancelAll(tableId);
	}

}
