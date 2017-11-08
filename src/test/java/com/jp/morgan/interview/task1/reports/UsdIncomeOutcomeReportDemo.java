package com.jp.morgan.interview.task1.reports;

import com.jp.morgan.interview.task1.entities.Instruction;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;


// Created by pavel.plakhotnik on 2017-11-06.

/**
 *
 */
public class UsdIncomeOutcomeReportDemo {
	private static final String REPORT_FILE = "/logs/temp/inout.txt";

	@Test
	public void simple() {
		List<Instruction> instructions = TestData.create();
		UsdIncomeOutcomeReport report = new UsdIncomeOutcomeReport(instructions, REPORT_FILE);
		report.doReport();
	}
}