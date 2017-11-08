package com.jp.morgan.interview.task2.entities.messages.entities;

// Created by pavel.plakhotnik on 2017-11-07.

import com.jp.morgan.interview.task2.entities.messages.MessageType;

/**
 *
 */
public abstract class AbstractMessage {
	private final MessageType type;
	private Long id;

	public AbstractMessage(MessageType type) {
		this.type = type;
	}

	protected abstract void construct();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MessageType getType() {
		return type;
	}
}
