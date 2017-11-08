package com.jp.morgan.interview.main;

import com.jp.morgan.interview.utils.TstNGConf;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

/**
 * Created by pavel.plakhotnik on 7/2/2016.
 */
public class AppTest extends Assert {
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(AppTest.class);

	@Test
	public void main() {
		log.info("Test");
		assertTrue(true);
		log.info("Test value {}", TstNGConf.getConfig().getString("just_test"));
	}

	@Test
	public void checkFile() {
		File file = new File(TstNGConf.FILE_NAME_AND_PATH);
		assertTrue(file.exists());
	}
}
