package com.oms.order.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table
@Data
public class OrderObj{

	@Id
	@Basic(optional = false)
	private String orderNo;
	private String customerId;
	private String customerName;
	private String orderType;
	private Double orderTotal;
	private ZonedDateTime createTimestamp;
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderLine> orderLines;

	public OrderObj(String orderNo, String customerId, String customerName,
						 String orderType, ZonedDateTime createTimestamp, Double orderTotal) {
		this.orderNo=orderNo;
		this.customerId=customerId;
		this.customerName=customerName;
		this.orderType=orderType;
		this.createTimestamp=createTimestamp;
		this.orderTotal=orderTotal;
	}

	public OrderObj() {
		super();
	}

	public Double getOrderTotal() {	return orderTotal; }

	public void setOrderTotal(Double orderTotal) {	this.orderTotal = orderTotal;}

	public String getCustomerId() {	return customerId;	}

	public void setCustomerId(String customerId) {	this.customerId = customerId;}

	public String getOrderType() {	return orderType;	}

	public void setOrderType(String orderType) { this.orderType = orderType;	}

	public String getOrderNo() {	return orderNo;	}

	public void setOrderNo(String orderNo) {	this.orderNo = orderNo;	}

	public String getCustomerName() { return customerName;	}

	public void setCustomerName(String customerName) {	this.customerName = customerName;}

	public ZonedDateTime getCreateTimestamp() { return createTimestamp;	}

	public void setCreateTimestamp(ZonedDateTime createTimestamp) {	this.createTimestamp = createTimestamp;	}

	public List<OrderLine> getOrderLines() { return orderLines; 	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
//		orderLines.forEach(entity -> entity.setOrder(this));
	}

}
