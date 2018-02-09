package com.orderingsystem.controller;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orderingsystem.dao.DataDAO;
import com.orderingsystem.dao.DataDAOFactory;
import com.orderingsystem.model.Menu;
import com.orderingsystem.model.MenuItem;
import com.orderingsystem.model.Restaurant;

@RestController
@RequestMapping("/")
public class SystemController {

	// url : /restaurants
	@Cacheable(value ="restaurants")
	@RequestMapping(value = "/restaurants", method = {RequestMethod.GET, RequestMethod.POST})
	public List<Restaurant> getRestaurants(){
		System.out.println("here");
		DataDAOFactory factory = new DataDAOFactory();
		DataDAO restaurantDAO = factory.getDataDAOFactory("restaurants");
		System.out.println("got something");
		List<Restaurant> restaurantList = restaurantDAO.getDataList();
		
		return restaurantList;
	}
	
	// url : /restaurants/{id}/menus
	@Cacheable(value="menus", key="#restaurantId")
	@RequestMapping(value = "/restaurants/{restaurantId}/menus", method = {RequestMethod.GET, RequestMethod.POST})
	public List<Menu> getMenus(@PathVariable("restaurantId") String restaurantId){
		
		DataDAOFactory factory = new DataDAOFactory();
		DataDAO menuDAO = factory.getDataDAOFactory("menus");
		
		List<Menu> menuList = menuDAO.getDataList(restaurantId);
		
		return menuList;
	}
	
	@Cacheable(value="menuItems", key="#restaurantId.toString() + #menuId.toString()")
	@RequestMapping(value = "/restaurants/{restaurantId}/menus/{menuId}/menuitems", method = {RequestMethod.GET, RequestMethod.POST})
	public List<MenuItem> getMenuItems(@PathVariable("restaurantId") String restaurantId, @PathVariable("menuId") String menuId){
		
		DataDAOFactory factory = new DataDAOFactory();
		DataDAO menuItemDAO = factory.getDataDAOFactory("menuitems");
		
		List<MenuItem> menuItemList = menuItemDAO.getDataList(restaurantId, menuId);
		
		return menuItemList;
	}
	
	@CacheEvict(value = "restaurants", allEntries = true)
	@RequestMapping(value = "/restaurants", method = RequestMethod.DELETE)
	public void deleteRestaurants() {
		
		DataDAOFactory factory = new DataDAOFactory();
		DataDAO commonDAO = factory.getDataDAOFactory("restaurants");
		Restaurant restaurant = new Restaurant();
		commonDAO.deleteData(restaurant);
	}
	
	@CacheEvict(value="menus", key="#restaurantId")
	@RequestMapping(value = "/restaurants/{restaurantId}/menus/{menuId}", method = RequestMethod.DELETE)
	public void deleteMenu(@PathVariable("restaurantId") int restaurantId, @PathVariable("menuId") int menuId) {
		DataDAOFactory factory = new DataDAOFactory();
		DataDAO menuDAO = factory.getDataDAOFactory("menus");
		
		Menu menu = new Menu(menuId, restaurantId);
		menuDAO.deleteData(menu);
	}
	
	@CacheEvict(value="menuItems", key="#restaurantId.toString() + #menuId.toString()")
	@RequestMapping(value = "/restaurants/{restaurantId}/menus/{menuId}/menuitems/{itemId}", method = RequestMethod.DELETE)
	public void deleteMenuItem(@PathVariable("restaurantId") int restaurantId, @PathVariable("menuId") int menuId, @PathVariable("itemId") int itemId) {
		DataDAOFactory factory = new DataDAOFactory();
		DataDAO menuItemDAO = factory.getDataDAOFactory("menuitems");
		
		MenuItem menuItem = new MenuItem(itemId, menuId, restaurantId);
		menuItemDAO.deleteData(menuItem);
	}
	
	
}
