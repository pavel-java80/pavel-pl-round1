package com.jp.morgan.interview.utils;

// Created by pavel.plakhotnik on 2017-11-06.

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 */
public class WriteToTextFile {
	public void create(final String fileNameWithPath, AbstractWriteToTextFileWork work) {

		Path outFile = Paths.get(fileNameWithPath);

		try {
			Files.deleteIfExists(outFile);
			Files.createFile(outFile);
		} catch (IOException e) {
			throw new RuntimeException(new StringBuilder("Cannot create file ")
					.append(fileNameWithPath).toString(), e);
		}

		try (BufferedWriter writer = Files.newBufferedWriter(outFile,
				StandardCharsets.UTF_8, StandardOpenOption.WRITE)) {

			work.setWriter(writer);
			work.work();
		} catch (IOException e) {
			throw new RuntimeException(new StringBuilder("Cannot write to file ")
					.append(outFile.toString()).toString()
			);
		}

	}

}
