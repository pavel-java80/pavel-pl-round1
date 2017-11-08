package com.jp.morgan.interview.task2.entities.messages.entities;

// Created by pavel.plakhotnik on 2017-11-07.

import com.jp.morgan.interview.task2.entities.Product;
import com.jp.morgan.interview.task2.entities.messages.MessageType;
import com.jp.morgan.interview.task2.enums.OperationType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Message3 extends AbstractMessage {
	public Message3(MessageType type) {
		super(type);
	}

	private List<Product> products;
	private OperationType operationType;
	private BigDecimal operationValue;

	public List<Product> getProducts() {
		if (products == null) products = new ArrayList<>();
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public BigDecimal getOperationValue() {
		return operationValue;
	}

	public void setOperationValue(BigDecimal operationValue) {
		this.operationValue = operationValue;
	}

	@Override
	protected void construct() {

	}
}
