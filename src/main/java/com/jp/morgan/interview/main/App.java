package com.jp.morgan.interview.main;

import com.jp.morgan.interview.utils.ApplicationConf;
import org.slf4j.Logger;


import java.util.Date;

/**
 * Just for testing...
 */
public class App {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		log.trace("Hello TRACE");
		log.debug("Hello DEBUG");
		log.info("Hello INFO");
		log.warn("Hello WARN");
		log.error("Hello ERROR");
		log.info("today is {}", new Date());


		final String key = "my_param";

		if (ApplicationConf.getConfig().containsKey(key)) {
			String str = ApplicationConf.getConfig().getString(key);
			log.info("Str = {}", str);
		}

		log.info("Normal shutdown");
	}


}
