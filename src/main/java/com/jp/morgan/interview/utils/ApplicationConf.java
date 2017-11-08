package com.jp.morgan.interview.utils;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;

/**
 * Just in case.
 */
public class ApplicationConf {
	private static final String APPLICATION_CONFIGURATION_FILE_NAME_DEFAULT = "conf/application.properties";
	private static final String APPLICATION_CONFIGURATION_FILE_NAME = "src/main/resources/conf/"
			+ APPLICATION_CONFIGURATION_FILE_NAME_DEFAULT;
	private static final CompositeConfiguration config = new CompositeConfiguration();
	static {
		gatherConfiguration(config, APPLICATION_CONFIGURATION_FILE_NAME_DEFAULT, APPLICATION_CONFIGURATION_FILE_NAME);
	}

	public static void gatherConfiguration(CompositeConfiguration config, final String FILE_NAME,
			String FILE_NAME_WITH_PATH) {
		config.addConfiguration(new SystemConfiguration());
		try {
			config.addConfiguration(new PropertiesConfiguration(FILE_NAME_WITH_PATH));
		} catch (ConfigurationException e) {
			try {
				config.addConfiguration(new PropertiesConfiguration(FILE_NAME));
			} catch (ConfigurationException e2) {
				System.out.println("cannot find conf file");
			}

		}

	}

	static public CompositeConfiguration getConfig() {
		return config;
	}
}
