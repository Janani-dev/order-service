package com.oms.order.controller;

import com.oms.order.entities.OrderObj;
import com.oms.order.exception.OrderServiceException;
import com.oms.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for createOrder
 */
@RestController
@RequestMapping("/v1")
public class OrderController {

	protected static final Logger logger = LoggerFactory.getLogger(RestController.class);
	@Autowired
	private OrderService orderService;

	@PostMapping("/createOrder")
	@PreAuthorize("hasRole('USER')")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<OrderObj> createOrder(@RequestBody OrderObj orderObj)
			throws Exception {
		ResponseEntity<OrderObj> result = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		if(logger.isDebugEnabled())logger.debug("Request for createOrder::"+orderObj.toString());
			try {
				result = ResponseEntity.ok(orderService.save(orderObj));
			} catch (Exception e) {
				throw new OrderServiceException(e.getMessage(),e.getCause());
			}
			return result;
	}

	@GetMapping("/getOrderDetails")
	@PreAuthorize("hasRole('USER')")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<OrderObj> getOrderDetails
			(@RequestParam(value = "orderNo", required = true) String orderNo)
			throws Exception {
		ResponseEntity<OrderObj> result = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		if(logger.isDebugEnabled())logger.debug("Request for getOrderDetails::"+orderNo);
		try {
			result = ResponseEntity.ok(orderService.getOrderDetails(orderNo));
		} catch (Exception e) {
			throw new OrderServiceException(e.getMessage(),e.getCause());
		}
		return result;
	}

	@GetMapping("/getOrderList")
	@PreAuthorize("hasRole('USER')")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<OrderObj>> getOrderListForCustomer(
			@RequestParam(value = "custId", required = true) String customerId)
			throws Exception {
		ResponseEntity<List<OrderObj>> result = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		if(logger.isDebugEnabled())logger.debug("Request for getOrderList for customerId::"+customerId);
		try {
			result = ResponseEntity.ok(orderService.getOrderList(customerId));
		} catch (Exception e) {
			throw new OrderServiceException(e.getMessage(),e.getCause());
		}
		return result;
	}
}