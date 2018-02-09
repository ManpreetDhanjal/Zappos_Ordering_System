package com.orderingsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.orderingsystem.model.Menu;
import com.orderingsystem.model.Restaurant;

public class RestaurantDAO extends DataDAO{

	public void saveData(Restaurant restaurant) {
		template.save(restaurant);
	}
	
	public void updateData(Restaurant restaurant) {
		template.update(restaurant);
	}
	
	public void deleteData(Restaurant restaurant) {
		template.delete(restaurant);
		
		Menu menu = new Menu(restaurant.getId());
		template.delete(menu);
	}
	
	@Override
	public List<Restaurant> getDataList(String ...strings){
		List<Restaurant> list = new ArrayList<Restaurant>();
		list = template.loadAll(Restaurant.class);
		return list;
	}
}
