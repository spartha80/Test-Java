package com.restaurant.commoninterfaces;

public interface Meal {
	public void startMeal(Long id);
	public void stopMeal(Long id);
	public void addItem(Long tableid, Long itemId, int itemCount);
	public void cancelItem(Long tableid, Long itemId, int itemCount);
	public void cancelAll(Long tableid);
}
