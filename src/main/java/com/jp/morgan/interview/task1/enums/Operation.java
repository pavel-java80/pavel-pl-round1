package com.jp.morgan.interview.task1.enums;

// Created by pavel.plakhotnik on 2017-11-06.

/**
 *
 */
public enum Operation {
	BUY("B", "buy"),
	SELL("S", "sell")
	;

	private final String dbValue;
	private final String description;

	private Operation(String dbValue, String description) {
		this.dbValue = dbValue;
		this.description = description;
	}

	public String getDbValue() { return dbValue; }
	public String getDescription() { return description; }

}
