package com.jp.morgan.interview.task2.entities.messages.entities;

// Created by pavel.plakhotnik on 2017-11-07.

import com.jp.morgan.interview.task2.entities.Sale;
import com.jp.morgan.interview.task2.entities.messages.MessageType;

import java.util.List;

/**
 *
 */
public class Message2 extends AbstractMessage {
	public Message2(MessageType type) {
		super(type);
	}

	private List<Sale> sales;

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	@Override
	protected void construct() {

	}
}
