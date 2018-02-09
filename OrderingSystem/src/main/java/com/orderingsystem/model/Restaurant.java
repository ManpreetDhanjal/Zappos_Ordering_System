package com.orderingsystem.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Restaurant extends Base implements Serializable{

	ArrayList<Menu> menuList;
	
	public ArrayList<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(ArrayList<Menu> menuList) {
		this.menuList = menuList;
	}
	
}
