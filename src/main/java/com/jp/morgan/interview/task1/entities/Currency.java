package com.jp.morgan.interview.task1.entities;

// Created by pavel.plakhotnik on 2017-11-06.

/**
 *
 */
public class Currency {
	private Long id;
	private String shortName;
	private String nameOfCountry;

	public Currency(Long id, String shortName) {
		this.id = id;
		this.shortName = shortName;
	}

	public Currency(Long id, String shortName, String nameOfCountry) {
		this(id, shortName);
		this.nameOfCountry = nameOfCountry;
	}

	public Long getId() {
		return id;
	}

	public String getShortName() {
		return shortName;
	}

	public String getNameOfCountry() {
		return nameOfCountry;
	}
}
