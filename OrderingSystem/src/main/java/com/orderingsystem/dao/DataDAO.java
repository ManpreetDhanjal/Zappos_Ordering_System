package com.orderingsystem.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.orderingsystem.model.Base;
import com.orderingsystem.model.MenuItem;

public class DataDAO<T> {

HibernateTemplate template;
	

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public List<T> getDataList(String...strings ) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteData(Base base) {
		// TODO Auto-generated method stub
		
	}
}
