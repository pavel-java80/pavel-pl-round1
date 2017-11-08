package com.jp.morgan.interview.task1.reports;

// Created by pavel.plakhotnik on 2017-11-06.

import com.jp.morgan.interview.task1.entities.Currency;
import com.jp.morgan.interview.task1.entities.FinEntity;
import com.jp.morgan.interview.task1.entities.Instruction;
import com.jp.morgan.interview.task1.enums.Operation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TestData {
	public static List<Instruction> create() {
		Currency aed = new Currency(1L, "AED");
		Currency sgp = new Currency(2L, "SGP");

		FinEntity bigEmirateFirm = new FinEntity(1L, "Big Emirate Firm");
		FinEntity bigSaudiFirm = new FinEntity(2L, "Big Saudi Firm");

		List<Instruction> toReturn = new ArrayList<>();
		// Buying
		toReturn.add(Instruction.newBuilder()
				.setOperation(Operation.BUY)
				.setSettlementDate(LocalDate.of(2017, Month.SEPTEMBER, 4))
				.setInstructionDate(LocalDate.of(2017, Month.SEPTEMBER, 6))
				.setCurrency(aed)
				.setFinEntity(bigEmirateFirm)
				.setAgreedFx(new BigDecimal(".27"))
				.setUnits(100L)
				.setPricePerUnit(new BigDecimal("100"))
				.build());

		toReturn.add(Instruction.newBuilder()
				.setOperation(Operation.BUY)
				.setSettlementDate(LocalDate.of(2017, Month.SEPTEMBER, 5))
				.setInstructionDate(LocalDate.of(2017, Month.SEPTEMBER, 6))
				.setCurrency(aed)
				.setFinEntity(bigEmirateFirm)
				.setAgreedFx(new BigDecimal(".27"))
				.setUnits(100L)
				.setPricePerUnit(new BigDecimal("100"))
				.build());

		toReturn.add(Instruction.newBuilder()
				.setOperation(Operation.BUY)
				.setSettlementDate(LocalDate.of(2017, Month.SEPTEMBER, 12))
				.setInstructionDate(LocalDate.of(2017, Month.SEPTEMBER, 28))
				.setCurrency(sgp)
				.setFinEntity(bigSaudiFirm)
				.setAgreedFx(new BigDecimal(".5"))
				.setUnits(100L)
				.setPricePerUnit(new BigDecimal("100"))
				.build());

		toReturn.add(Instruction.newBuilder()
				.setOperation(Operation.BUY)
				.setSettlementDate(LocalDate.of(2017, Month.SEPTEMBER, 14))
				.setInstructionDate(LocalDate.of(2017, Month.SEPTEMBER, 28))
				.setCurrency(sgp)
				.setFinEntity(bigSaudiFirm)
				.setAgreedFx(new BigDecimal(".5"))
				.setUnits(100L)
				.setPricePerUnit(new BigDecimal("100"))
				.build());

		toReturn.add(Instruction.newBuilder()
				.setOperation(Operation.BUY)
				.setSettlementDate(LocalDate.of(2017, Month.SEPTEMBER, 15))
				.setInstructionDate(LocalDate.of(2017, Month.SEPTEMBER, 28))
				.setCurrency(sgp)
				.setFinEntity(new FinEntity(3L, "Small saudy client"))
				.setAgreedFx(new BigDecimal(".5"))
				.setUnits(5L)
				.setPricePerUnit(new BigDecimal("100"))
				.build());

		// selling
		toReturn.add(Instruction.newBuilder()
				.setOperation(Operation.SELL)
				.setSettlementDate(LocalDate.of(2017, Month.SEPTEMBER, 4))
				.setInstructionDate(LocalDate.of(2017, Month.SEPTEMBER, 6))
				.setCurrency(aed)
				.setFinEntity(bigEmirateFirm)
				.setAgreedFx(new BigDecimal(".27"))
				.setUnits(100L)
				.setPricePerUnit(new BigDecimal("100"))
				.build());

		toReturn.add(Instruction.newBuilder()
				.setOperation(Operation.SELL)
				.setSettlementDate(LocalDate.of(2017, Month.SEPTEMBER, 5))
				.setInstructionDate(LocalDate.of(2017, Month.SEPTEMBER, 6))
				.setCurrency(aed)
				.setFinEntity(bigEmirateFirm)
				.setAgreedFx(new BigDecimal(".27"))
				.setUnits(100L)
				.setPricePerUnit(new BigDecimal("100"))
				.build());

		toReturn.add(Instruction.newBuilder()
				.setOperation(Operation.SELL)
				.setSettlementDate(LocalDate.of(2017, Month.SEPTEMBER, 12))
				.setInstructionDate(LocalDate.of(2017, Month.SEPTEMBER, 28))
				.setCurrency(sgp)
				.setFinEntity(bigSaudiFirm)
				.setAgreedFx(new BigDecimal(".5"))
				.setUnits(200L)
				.setPricePerUnit(new BigDecimal("100"))
				.build());

		toReturn.add(Instruction.newBuilder()
				.setOperation(Operation.SELL)
				.setSettlementDate(LocalDate.of(2017, Month.SEPTEMBER, 14))
				.setInstructionDate(LocalDate.of(2017, Month.SEPTEMBER, 28))
				.setCurrency(sgp)
				.setFinEntity(bigSaudiFirm)
				.setAgreedFx(new BigDecimal(".5"))
				.setUnits(100L)
				.setPricePerUnit(new BigDecimal("100"))
				.build());

		toReturn.add(Instruction.newBuilder()
				.setOperation(Operation.SELL)
				.setSettlementDate(LocalDate.of(2017, Month.SEPTEMBER, 15))
				.setInstructionDate(LocalDate.of(2017, Month.SEPTEMBER, 28))
				.setCurrency(sgp)
				.setFinEntity(new FinEntity(3L, "Small saudy client"))
				.setAgreedFx(new BigDecimal(".5"))
				.setUnits(5L)
				.setPricePerUnit(new BigDecimal("100"))
				.build());


		return toReturn;
	}
}
