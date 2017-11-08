package com.jp.morgan.interview.main;

import com.jp.morgan.interview.utils.ApplicationConf;
import org.slf4j.Logger;

import org.joda.time.LocalDate;

import java.util.Date;

public class App {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		log.trace("Hello TRACE");
		log.debug("Hello DEBUG");
		log.info("Hello INFO");
		log.warn("Hello WARN");
		log.error("Hello ERROR");
		log.info("today is {}", new Date());

		System.out.println(getLocalCurrentDate());

		final String key = "my_param";

		if (ApplicationConf.getConfig().containsKey(key)) {
			String str = ApplicationConf.getConfig().getString(key);
			log.info("Str = {}", str);
		}

		log.info("Normal shutdown");
	}

	private static String getLocalCurrentDate() {

		if (log.isDebugEnabled()) {
			log.debug("getLocalCurrentDate() is executed!");
		}

		LocalDate date = new LocalDate();
		return date.toString();

	}

}
