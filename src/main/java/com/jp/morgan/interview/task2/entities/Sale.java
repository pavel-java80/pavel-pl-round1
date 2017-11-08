package com.jp.morgan.interview.task2.entities;

// Created by pavel.plakhotnik on 2017-11-07.

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 */
public class Sale {
	private Long id;
	private LocalDate date;
	private Product product;
	private int qty;
	private BigDecimal price;

	private Sale() {}

	public static Sale newBuilder() {
		return new Sale();
	}

	public Long getId() { return id; }
	public LocalDate getDate() { return date; }
	public Product getProduct() { return product; }
	public int getQty() { return qty; }
	public BigDecimal getPrice() { return price; }

	public Sale setId(Long id) {
		this.id = id; return this;
	}
	public Sale setDate(LocalDate date) {
		this.date = date; return this;
	}
	public Sale setProduct(Product product) {
		this.product = product; return this;
	}
	public Sale setQty(int qty) {
		this.qty = qty; return this;
	}
	public Sale setPrice(BigDecimal price) {
		this.price = price; return this;
	}

	public BigDecimal total() {
		return price.multiply(BigDecimal.valueOf(qty));
	}

}
