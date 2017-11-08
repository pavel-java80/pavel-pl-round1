package com.jp.morgan.interview.utils;

import org.apache.commons.configuration.CompositeConfiguration;

/**
 * properties for testing
 */
public class TstNGConf {
	private static final String FILE_NAME = "main_test.properties";
	public static final String FILE_NAME_AND_PATH = "src/test/resources/testConf/" + FILE_NAME;
	private static final CompositeConfiguration config = new CompositeConfiguration();

	static {
		ApplicationConf.gatherConfiguration(config, FILE_NAME, FILE_NAME_AND_PATH);
	}

	static public CompositeConfiguration getConfig() {
		return config;
	}

}
