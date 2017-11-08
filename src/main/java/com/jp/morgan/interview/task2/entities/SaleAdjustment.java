package com.jp.morgan.interview.task2.entities;

// Created by pavel.plakhotnik on 2017-11-07.

import com.jp.morgan.interview.task2.enums.OperationType;

import java.math.BigDecimal;

/**
 *
 */
public class SaleAdjustment {
	private Sale sale;
	private OperationType operationType;
	private BigDecimal operationValue;

	public SaleAdjustment(Sale sale, OperationType operationType, BigDecimal operationValue) {
		this.sale = sale;
		this.operationType = operationType;
		this.operationValue = operationValue;
	}

	public Sale getSale() {
		return sale;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public BigDecimal getOperationValue() {
		return operationValue;
	}
}
