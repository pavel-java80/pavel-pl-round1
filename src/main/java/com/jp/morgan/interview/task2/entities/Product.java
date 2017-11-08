package com.jp.morgan.interview.task2.entities;

// Created by pavel.plakhotnik on 2017-11-07.

/**
 *
 */
public class Product {
	private Long id;
	private String name;

	public Product(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
