package com.jp.morgan.interview.task2.services;

// Created by pavel.plakhotnik on 2017-11-07.

import com.jp.morgan.interview.task2.entities.Product;
import com.jp.morgan.interview.task2.entities.Sale;
import com.jp.morgan.interview.task2.entities.messages.MessageType;
import com.jp.morgan.interview.task2.entities.messages.MessagesFactory;
import com.jp.morgan.interview.task2.entities.messages.entities.AbstractMessage;
import com.jp.morgan.interview.task2.entities.messages.entities.Message1;
import com.jp.morgan.interview.task2.entities.messages.entities.Message3;
import com.jp.morgan.interview.task2.enums.OperationType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TestTask2Data {

	public static List<AbstractMessage> create_3_messages1() {
		List<AbstractMessage> toReturn = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			toReturn.add(MessagesFactory.buildMessage(MessageType.Type1));
		}

		((Message1) toReturn.get(0))
				.setSale(Sale.newBuilder()
				.setId(1L)
				.setDate(LocalDate.of(2017, Month.SEPTEMBER, 4))
				.setProduct(TestTask2Data.getAppleProduct())
				.setQty(1)
				.setPrice(new BigDecimal("2")));
		((Message1) toReturn.get(1)).setSale(Sale.newBuilder()
				.setId(1L)
				.setDate(LocalDate.of(2017, Month.SEPTEMBER, 4))
				.setProduct(getPearProduct())
				.setQty(2)
				.setPrice(new BigDecimal("2.5")));
		((Message1) toReturn.get(2)).setSale(Sale.newBuilder()
				.setId(1L)
				.setDate(LocalDate.of(2017, Month.SEPTEMBER, 4))
				.setProduct(getGrapesProduct())
				.setQty(2)
				.setPrice(new BigDecimal("3")));

		final long[] id = {0L};
		toReturn.forEach(message -> message.setId(++id[0]));
		return toReturn;
	}


	public static Product getAppleProduct() {
		return new Product(1L, "apple");
	}

	public static Product getPearProduct() {
		return new Product(2L, "pear");
	}

	public static Product getGrapesProduct() {
		return  new Product(2L, "Grapes");
	}


	public static AbstractMessage createMessage3() {
		Message3 message = MessagesFactory.buildMessage(MessageType.Type3);
		message.setId(10L);
		message.getProducts().add(getAppleProduct());
		message.getProducts().add(getGrapesProduct());
		message.setOperationType(OperationType.ADD);
		message.setOperationValue(new BigDecimal("10"));
		return message;
	}
}
