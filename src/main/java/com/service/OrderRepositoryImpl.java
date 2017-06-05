package com.service;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Order;

@Service("orderRepository")
public class OrderRepositoryImpl extends HibernateDaoSupport implements OrderRepository{
	@Autowired
	SessionFactory sessionFactory;

	public OrderRepositoryImpl(SessionFactory sessionfactory){
	    setSessionFactory(sessionfactory);
	}

	
	private final Map<String, Order> orders = new ConcurrentHashMap<String, Order>();

	@Override
	@Transactional
	public void putOrder(Order order) {
		orders.put(order.getOrderId(), order);
		getHibernateTemplate().save(order);
	}

	@Override
	@Transactional
	public Order getOrder(String orderId) {
		System.out.println(getHibernateTemplate().get(Order.class,orderId));
		return orders.get(orderId);
	}
	@Override
	public Map<String, Order> getAllOrders(){
		return orders;
	}
	@Override
	@Transactional
	public List<Order> getAllOrdersFromDataBase(){
		return (List<Order>) sessionFactory.getCurrentSession().createCriteria(Order.class).list();
	}
}
