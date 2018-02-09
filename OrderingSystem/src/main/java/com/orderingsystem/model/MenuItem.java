package com.orderingsystem.model;

import java.io.Serializable;

public class MenuItem extends Base implements Serializable{

	int menuId;
	int restaurantId;
	String price;
	
	public MenuItem() {
		this.id = 0;
		this.menuId = 0;
		this.restaurantId = 0;
	}
	
	public MenuItem(int id, int menuId, int restaurantId) {
		this.id = id;
		this.menuId = menuId;
		this.restaurantId = restaurantId;
	}
	
	public MenuItem(int menuId, int restaurantId) {
		this.menuId = menuId;
		this.restaurantId = restaurantId;
	}
	
	public int getMenuId() {
		return menuId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
