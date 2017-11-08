package com.jp.morgan.interview.utils;

// Created by pavel.plakhotnik on 2017-11-06.

import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 */
public abstract class AbstractWriteToTextFileWork {
	private BufferedWriter writer;
	public void setWriter(BufferedWriter writer) { this.writer = writer; }


	public abstract void work() throws IOException;

	public void write(int tabs, String ... lines) throws IOException {
		try {
			for (int i = 0; i < tabs; i++) {
				writer.write("\t");
			}
			write(lines);
		} catch (IOException e) {
			new RuntimeException("Exception in writeln(String... lines)", e);
		}
	}

	public void write(String ... lines) throws IOException {
		try {
			for (int i = 0, len = lines.length; i < len; i++) {
				writer.write(lines[i]);
			}
		} catch (IOException e) {
			new RuntimeException("Exception in writeln(String... lines)", e);
		}
	}

	public void writeln(int tabs, String... lines) {
		try {
			for (int i = 0; i < tabs; i++) {
				writer.write("\t");
			}
			writeln(lines);
		} catch (IOException e) {
			new RuntimeException("Exception in writeln(String... lines)", e);
		}
	}

	public void writeln(String... lines)  {
		try {
			for (int i = 0, len = lines.length; i < len; i++) {
				writer.write(lines[i]);
			}
			writer.write("\n");
		} catch (IOException e) {
			new RuntimeException("Exception in writeln(String... lines)", e);
		}
	}

}
