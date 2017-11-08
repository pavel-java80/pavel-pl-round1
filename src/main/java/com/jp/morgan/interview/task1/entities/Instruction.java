package com.jp.morgan.interview.task1.entities;

// Created by pavel.plakhotnik on 2017-11-06.

import com.jp.morgan.interview.task1.enums.Operation;
import com.jp.morgan.interview.utils.DateUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * (made a builder in order to simplify filling the data for tests)
 */
public class Instruction {
	private FinEntity finEntity;
	private Operation operation;

	private BigDecimal agreedFx;

	private Currency currency;
	private LocalDate instructionDate;
	private LocalDate settlementDate;
	private long units;

	private BigDecimal pricePerUnit;

	private BigDecimal totalInUsd;

	private Instruction() {
	}

	public FinEntity getFinEntity() { return finEntity; }
	public Operation getOperation() { return operation; }
	public BigDecimal getAgreedFx() { return agreedFx; }
	public Currency getCurrency() { return currency; }
	public LocalDate getInstructionDate() { return instructionDate; }
	public LocalDate getSettlementDate() { return settlementDate; }
	public long getUnits() { return units; }
	public BigDecimal getPricePerUnit() { return pricePerUnit; }

	public static Builder newBuilder() {
		Builder toReturn = new Instruction().new Builder();
		return toReturn;
	}

	public class Builder {
		private Builder() {}
		public Builder setFinEntity(FinEntity finEntity) {
			Instruction.this.finEntity = finEntity; return this;
		}
		public Builder setOperation(Operation operation) {
			Instruction.this.operation = operation; return this;
		}
		public Builder setAgreedFx(BigDecimal agreedFx) {
			Instruction.this.agreedFx = agreedFx; return this;
		}
		public Builder setCurrency(Currency currency) {
			Instruction.this.currency = currency; return this;
		}
		public Builder setInstructionDate(LocalDate instructionDate) {
			DateUtils.assertWorkingDay(instructionDate);
			Instruction.this.instructionDate = instructionDate; return this;
		}
		public Builder setSettlementDate(LocalDate settlementDate) {
			DateUtils.assertWorkingDay(settlementDate);
			Instruction.this.settlementDate = settlementDate; return this;
		}
		public Builder setUnits(long units) {
			Instruction.this.units = units; return this;
		}
		public Builder setPricePerUnit(BigDecimal pricePerUnit) {
			Instruction.this.pricePerUnit = pricePerUnit; return this;
		}

		public Instruction build() {
			totalInUsd = BigDecimal.valueOf(units).multiply(pricePerUnit).multiply(agreedFx);
			return Instruction.this;
		}
	} // Builder class

	public BigDecimal getTotalInUsd() { return totalInUsd; }


	/*
	 * Business methods:
	 */

} // end of class Instruction

