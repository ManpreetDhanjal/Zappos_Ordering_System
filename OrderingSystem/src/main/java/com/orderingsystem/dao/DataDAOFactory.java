package com.orderingsystem.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataDAOFactory {

	public DataDAO getDataDAOFactory(String dataType) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/BeanLocations.xml");
		DataDAO dataDAO = (DataDAO) appContext.getBean("daoBean");
		
		if(dataType.equalsIgnoreCase("restaurants")) {
			RestaurantDAO restaurantDAO = new RestaurantDAO();
			restaurantDAO.setTemplate(dataDAO.getTemplate());
			return restaurantDAO;
		}else if(dataType.equalsIgnoreCase("menus")) {
			MenuDAO menuDAO = new MenuDAO();
			menuDAO.setTemplate(dataDAO.getTemplate());
			return menuDAO;
		}else if(dataType.equalsIgnoreCase("menuItems")) {
			MenuItemDAO menuItemDAO = new MenuItemDAO();
			menuItemDAO.setTemplate(dataDAO.getTemplate());
			return menuItemDAO;
		}

		return null;
		
	}
}
