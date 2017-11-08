package com.jp.morgan.interview.task2.services;

import com.jp.morgan.interview.task2.entities.messages.entities.AbstractMessage;
import com.jp.morgan.interview.utils.DateUtils;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;


// Created by pavel.plakhotnik on 2017-11-07.

/**
 *
 */
public class SalesProcessingTest {
	@Test
	public void processMessage3() {
		// given
		SalesProcessing processing = SalesProcessing.INSTANCE;
		List<AbstractMessage> list = TestTask2Data.create_3_messages1();
		list.add(TestTask2Data.createMessage3());
		processing.processing(list);

		// then
		assertEquals(4, processing.getMessagesCnt());
	}

}