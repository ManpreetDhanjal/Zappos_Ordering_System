package com.orderingsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.orderingsystem.model.Menu;
import com.orderingsystem.model.MenuItem;

public class MenuDAO extends DataDAO{

	public void saveData(Menu menu) {
		template.save(menu);
	}
	
	public void updateData(Menu menu) {
		template.update(menu);
	}
	
	public void deleteData(Menu menu) {
		template.delete(menu);
		MenuItem menuItem = new MenuItem(menu.getId(), menu.getRestaurantId());
		template.delete(menuItem);
	}
	
	public List<Menu> getDataList(String ...strings){
		List<Menu> list = new ArrayList<Menu>();
		list = (ArrayList<Menu>)template.find("from MenuItem where restaurantId = ?", Integer.parseInt(strings[0]));
		return list;
	}
}
