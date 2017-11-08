package com.jp.morgan.interview.task2.entities.messages.entities;

// Created by pavel.plakhotnik on 2017-11-07.

import com.jp.morgan.interview.task2.entities.Sale;
import com.jp.morgan.interview.task2.entities.messages.MessageType;

/**
 *
 */
public class Message1 extends AbstractMessage {
	public Message1(MessageType type) {
		super(type);
	}

	private Sale sale;

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	@Override
	protected void construct() {

	}
}
