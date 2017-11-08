package com.jp.morgan.interview.task2.services;

import com.jp.morgan.interview.task2.entities.Product;
import com.jp.morgan.interview.task2.entities.Sale;
import com.jp.morgan.interview.task2.entities.messages.MessageType;
import com.jp.morgan.interview.task2.entities.messages.MessagesFactory;
import com.jp.morgan.interview.task2.entities.messages.entities.AbstractMessage;
import com.jp.morgan.interview.task2.entities.messages.entities.Message1;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


// Created by pavel.plakhotnik on 2017-11-07.

/**
 *
 */
public class SalesProcessingDemo {
	@Test
	public void process_3_simpleMessages() {
		List<AbstractMessage> messages = TestTask2Data.create_3_messages1();
		SalesProcessing processing = SalesProcessing.INSTANCE;
		processing.processing(messages);
	}




}