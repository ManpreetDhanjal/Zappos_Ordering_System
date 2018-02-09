package com.orderingsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.orderingsystem.model.Menu;
import com.orderingsystem.model.MenuItem;

public class MenuItemDAO extends DataDAO{

	public void saveData(MenuItem menuItem) {
		template.save(menuItem);
	}
	
	public void updateData(MenuItem menuItem) {
		template.update(menuItem);
	}
	
	public void deleteData(MenuItem menuItem) {
		template.delete(menuItem);
	}
	
	@Override
	public List<MenuItem> getDataList(String ...strings){
		List<MenuItem> list = new ArrayList<MenuItem>();
		list = (ArrayList<MenuItem>)template.find("from MenuItem where restaurantId = ? and menuId = ?", Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
		return list;
	}
}
