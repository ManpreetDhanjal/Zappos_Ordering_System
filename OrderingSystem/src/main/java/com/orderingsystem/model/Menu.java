package com.orderingsystem.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Menu extends Base implements Serializable {

	int restaurantId;
	ArrayList<MenuItem> menuItemList;
	
	public Menu() {
		this.id = 0;
		this.restaurantId = 0;
	}
	
	public Menu(int id, int restaurantId) {
		this.id = id;
		this.restaurantId = restaurantId;
	}
	
	public Menu(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public ArrayList<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	public void setMenuItemList(ArrayList<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	
	
}
