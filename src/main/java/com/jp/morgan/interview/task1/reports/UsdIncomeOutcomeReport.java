package com.jp.morgan.interview.task1.reports;

// Created by pavel.plakhotnik on 2017-11-06.

import com.jp.morgan.interview.task1.entities.FinEntity;
import com.jp.morgan.interview.task1.entities.Instruction;
import com.jp.morgan.interview.task1.enums.Operation;
import com.jp.morgan.interview.utils.AbstractWriteToTextFileWork;
import com.jp.morgan.interview.utils.WriteToTextFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.String.format;

/**
 *
 */
public class UsdIncomeOutcomeReport {
	private List<Instruction> instructions;
	private String reportPathAndName;

	public UsdIncomeOutcomeReport(List<Instruction> instructions, String reportPathAndName) {
		this.instructions = instructions;
		this.reportPathAndName = reportPathAndName;
	}

	public void doReport() {
		CurrentReport report = new CurrentReport();
		new WriteToTextFile().create(reportPathAndName, report);
	}

	private class CurrentReport extends AbstractWriteToTextFileWork {
		@Override
		public void work() throws IOException {
			// Buying data preparation
			Map<LocalDate, BigDecimal> buyingMap = getLocalDateBigDecimalMap(Operation.BUY);
			Map<LocalDate, BigDecimal> sortedBuyingMap = sortByLocalDate(buyingMap);

			writeln("Ammount in USD settled buying by day:");

			// 0 - for buy, 1 - for sell
			final BigDecimal[] total = {BigDecimal.ZERO, BigDecimal.ZERO};
			sortedBuyingMap.forEach((k, v) -> {
				writeln(k.toString(), " : ", bigDataFormat(v));
				total[0] = total[0].add(v);
			});
			writeln("Total buying is : ", bigDataFormat(total[0]));
			writeln();

			writeln("Ammount in USD settled selling by day:");
			Map<LocalDate, BigDecimal> sellingMap = getLocalDateBigDecimalMap(Operation.SELL);
			Map<LocalDate, BigDecimal> sortedsellingMap = sortByLocalDate(sellingMap);
			sortedsellingMap.forEach((k, v) -> {
				writeln(k.toString(), " : ", bigDataFormat(v));
				total[1] = total[1].add(v);
			});
			writeln("Total selling is : ", bigDataFormat(total[1]));

			writeln();
			writeln("Clients with biggest buying operations:");
			Map<FinEntity, BigDecimal> buyingClientsMap = getClientsMap(Operation.BUY);
			Map<FinEntity, BigDecimal> sortedBuyingClientsMap = sortByClient(buyingClientsMap);
			sortedBuyingClientsMap.forEach((k, v) -> {
				writeln(k.getName(), " : ", bigDataFormat(v));
			});

			writeln();
			writeln("Clients with biggest selling operations:");
			Map<FinEntity, BigDecimal> sellingClientsMap = getClientsMap(Operation.SELL);
			Map<FinEntity, BigDecimal> sortedSellingClientsMap = sortByClient(sellingClientsMap);
			sortedSellingClientsMap.forEach((k, v) -> {
				writeln(k.getName(), " : ", bigDataFormat(v));
			});
		}
	}



	private Map<LocalDate, BigDecimal> getLocalDateBigDecimalMap(Operation operation) {
		return instructions.stream()
						.filter(instruction -> instruction.getOperation().equals(operation))
						.collect(Collectors.groupingBy(Instruction::getSettlementDate,
								Collectors.reducing(BigDecimal.ZERO,
										Instruction::getTotalInUsd, BigDecimal::add)));
	}

	private Map<LocalDate, BigDecimal> sortByLocalDate(Map<LocalDate, BigDecimal> unsortedMap) {
		return unsortedMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));
	}

	private Map<FinEntity, BigDecimal> getClientsMap(Operation operation) {
		return instructions.stream()
				.filter(instruction -> instruction.getOperation().equals(operation))
				.collect(Collectors.groupingBy(Instruction::getFinEntity,
						Collectors.reducing(BigDecimal.ZERO,
								Instruction::getTotalInUsd, BigDecimal::add)));
	}

	private Map<FinEntity, BigDecimal> sortByClient(Map<FinEntity, BigDecimal> unsortedMap) {
		return unsortedMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));
	}

	private String bigDataFormat(BigDecimal data) {
		return format(Locale.ENGLISH, "%,.2f", data.setScale(2, RoundingMode.DOWN));
	}

}
