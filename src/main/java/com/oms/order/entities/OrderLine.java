package com.oms.order.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

@Entity
public class OrderLine{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderLineKey;

	@ManyToOne
	@JoinColumn(name="order_no")
	private OrderObj orderObj;
	private Integer lineNo;
	private String itemId;
	private String itemDesc;
	private Double quantity;
	private String unitOfMeasure;
	private Double lineTotal;

	public OrderLine(Integer lineNo, String itemId, String itemDesc,
					String unitOfMeasure, Double quantity, Double lineTotal) {
		this.lineNo=lineNo;
		this.itemId=itemId;
		this.itemDesc=itemDesc;
		this.unitOfMeasure=unitOfMeasure;
		this.quantity=quantity;
		this.lineTotal=lineTotal;
	}

	public OrderLine() {
		super();
	}

	public Integer getLineNo() {
		return lineNo;
	}

	public void setLineNo(Integer lineNo) {
		this.lineNo = lineNo;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public Double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}

	public Long getOrderLineKey() {	return orderLineKey;	}

	public String getItemDesc() {	return itemDesc;	}

	public void setItemDesc(String itemDesc) {	this.itemDesc = itemDesc;	}

	public OrderObj getOrder() { return orderObj;	}

	public void setOrder(OrderObj orderObj) {	this.orderObj = orderObj;	}

//	@Override
//	public String toString() {
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			return mapper.writeValueAsString(this);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//			return this.toString();
//		}
//	}

//	@Override
//	public boolean equals(Object obj) {
//		OrderLine orderLineOjb = (OrderLine) obj;
//		return this.getLineNo().compareTo(orderLineOjb.getLineNo()) == 0;
//	}
	
//	@Override
//	public int hashCode() {
//		return super.hashCode();
//	}
}
