package com.restaurant.menu;

public class Item {
	private Long menuId;
	private int count;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(Long menuId, int count) {
		this.setMenuId(menuId);
		this.setCount(count);
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
