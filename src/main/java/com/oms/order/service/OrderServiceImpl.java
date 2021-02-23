package com.oms.order.service;

import com.oms.order.entities.OrderObj;
import com.oms.order.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

	public static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	@Autowired
	private final OrderRepository orderRepo;
	public OrderServiceImpl(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}

//	@Transactional(rollbackFor = Exception.class)
	@Override
	public OrderObj save(OrderObj ord) {
		ZonedDateTime createTimeStamp = ZonedDateTime.now();
		ord.setCreateTimestamp(createTimeStamp);
		return orderRepo.save(ord);
	}

	@Override
	public List<OrderObj> getOrderList(String customerID) {
		return orderRepo.findOrderObjsByCustomerId(customerID);
	}

	@Override
	public OrderObj getOrderDetails(String orderNo) {return orderRepo.findOrderObjByOrderNo(orderNo);}
}