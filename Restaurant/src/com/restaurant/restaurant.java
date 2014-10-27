package com.restaurant;

import com.restaurant.client.Table;
import com.restaurant.commoninterfaces.MenuBuilder;

public class restaurant {

	public restaurant() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Table t = new Table();
		t.setId(1L);
		MenuBuilder builder = MenuBuilder.getInstance();
		t.startMeal(t.getId());
		t.addItem(t.getId(), builder.getItemInfo("Tomato Soup").getItemId(), 1);
		t.addItem(t.getId(), builder.getItemInfo("Coleslaw Sandwich").getItemId(), 2);
		t.addItem(t.getId(), builder.getItemInfo("Tomato Soup").getItemId(), 1);
		t.addItem(t.getId(), builder.getItemInfo("Bottled Water").getItemId(), 2);
		t.cancelItem(t.getId(), builder.getItemInfo("Bottled Water").getItemId(), 1);
		t.stopMeal(t.getId());
		System.out.println("t.getId() " + t.getId());
	}

}
