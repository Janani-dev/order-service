package com.oms.order.repository;

import com.oms.order.entities.OrderObj;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderObj,Long> {
	OrderObj findOrderObjByOrderNo(String orderNo);
	List<OrderObj> findOrderObjsByCustomerId(String customerID);
	OrderObj save(OrderObj order);
}

