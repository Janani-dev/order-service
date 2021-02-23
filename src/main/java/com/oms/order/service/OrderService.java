package com.oms.order.service;

import com.oms.order.entities.OrderObj;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
	OrderObj save(OrderObj po);
	List<OrderObj> getOrderList(String customerID);
	OrderObj getOrderDetails(String orderNo);
}