package com.jp.morgan.interview.task2.entities.messages;

// Created by pavel.plakhotnik on 2017-11-07.

import com.jp.morgan.interview.task2.entities.messages.entities.AbstractMessage;
import com.jp.morgan.interview.task2.entities.messages.entities.Message1;
import com.jp.morgan.interview.task2.entities.messages.entities.Message2;
import com.jp.morgan.interview.task2.entities.messages.entities.Message3;

/**
 *
 */
public class MessagesFactory {
	public static <T extends AbstractMessage> T buildMessage(MessageType type) {
		T message = null;
		switch (type) {
			case Type1:
				message = (T) new Message1(type);
				break;
			case Type2:
				message = (T) new Message2(type);
				break;
			case Type3:
				message = (T) new Message3(type);
				break;
			default:
				throw new RuntimeException("wrong given type " + type);
		}
		return message;
	}

}
