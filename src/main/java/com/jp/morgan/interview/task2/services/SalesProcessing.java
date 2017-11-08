package com.jp.morgan.interview.task2.services;

// Created by pavel.plakhotnik on 2017-11-07.


import com.jp.morgan.interview.task2.entities.Sale;
import com.jp.morgan.interview.task2.entities.SaleAdjustment;
import com.jp.morgan.interview.task2.entities.messages.entities.AbstractMessage;
import com.jp.morgan.interview.task2.entities.messages.entities.Message1;
import com.jp.morgan.interview.task2.entities.messages.entities.Message2;
import com.jp.morgan.interview.task2.entities.messages.entities.Message3;

import java.math.BigDecimal;
import java.util.*;

/**
 *
 */
public enum SalesProcessing {
	INSTANCE;

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SalesProcessing.class);

	private long messagesCnt = 0L;
	private List<Sale> sales; // like database
	// 1 - product code, 2 - sum per product
	private Map<Long, BigDecimal> totalSalesForPack;
	private List<SaleAdjustment> salesAdjustments;

	public long getMessagesCnt() {
		return messagesCnt;
	}

	public List<Sale> getSales() {
		if (sales == null) sales = new ArrayList<>();
		return sales;
	}

	public Map<Long, BigDecimal> getTotalSalesForPack() {
		if (totalSalesForPack == null) totalSalesForPack = new LinkedHashMap<>();
		return totalSalesForPack;
	}

	public List<SaleAdjustment> getSalesAdjustments() {
		if (salesAdjustments == null) salesAdjustments = new LinkedList<>();
		return salesAdjustments;
	}

	public void processing(List<AbstractMessage> messages) {
		for (AbstractMessage message : messages) {
			switch (message.getType()) {
				case Type1:
					processMessage1((Message1) message);
					break;
				case Type2:
					processMessage2((Message2) message);
					break;
				case Type3:
					processMessage3((Message3) message);
					break;
				default:
					log.error("Message with type {} was't proceeded", message.getType());
					continue;
			}
			if (++messagesCnt % 10 == 0) {
				logAfter10recores();
			}
			if (messagesCnt % 50 == 0) {
				logAfter50recores();
			}
		}
	}

	private void logAfter10recores() {
		log.info("processed {} ", messagesCnt);
		final BigDecimal[] total = {BigDecimal.ZERO};
		getTotalSalesForPack().forEach((k, v) -> {
			log.info("Sales per product {} sum {}", k, v);
			total[0] = total[0].add(v);
		});

		log.info("Total: {}", total[0]);

		getTotalSalesForPack().clear();
	}

	private void logAfter50recores() {
		log.info("processing of massages is paused");
		log.info("list of adjustments:");
		getSalesAdjustments().forEach(adj -> {
			log.info("Product id={} operation {} value {}",
					adj.getSale().getProduct().getId(), adj.getOperationType(),
					adj.getOperationValue());
		});

		getSalesAdjustments().clear();
	}

	private void addToCollections(Sale sale) {
		getSales().add(sale);
		getTotalSalesForPack().merge(sale.getProduct().getId(),
				sale.getPrice(), BigDecimal::add );
	}


	private void processMessage1(Message1 message) {
		if (message.getSale() == null) {
			final String errMessage = String.format("Message1 id=%d has no sale", message.getId());
			log.error(errMessage);
			throw new RuntimeException(errMessage);
		} else if (message.getSale().getProduct() == null) {
			final String errMessage = String.format("Message1 id=%d has no product", message.getId());
			log.error(errMessage);
			throw new RuntimeException(errMessage);
		}
		addToCollections(message.getSale());
	}


	private void processMessage2(Message2 message) {
		for (Sale sale : message.getSales()) {
			addToCollections(sale);
		}
	}

	private void processMessage3(Message3 message) {
		// getSales().forEach();
		message.getProducts().forEach(product -> {
			getSales().forEach(sale -> {
				if (product.getId().equals(sale.getId())) {
					switch (message.getOperationType()) {
						case ADD:
							sale.setPrice(sale.getPrice().add(message.getOperationValue()));
							break;
						case MULTIPLY:
							sale.setPrice(sale.getPrice().multiply(message.getOperationValue()));
							break;
						case SUBSTRACT:
							sale.setPrice(sale.getPrice().subtract(message.getOperationValue()));
							break;
						case DIVIDE:
							sale.setPrice(sale.getPrice().divide(message.getOperationValue()));
							break;
						default:
							throw new RuntimeException("Wrong message parameter " + message.getOperationType());
					}
					getSalesAdjustments().add(new SaleAdjustment(sale,
							message.getOperationType(), message.getOperationValue()));
				}
			});
		});
	}
}
