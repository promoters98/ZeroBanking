package rough;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JDemo {

	public static void main(String[] args) {
		
		Logger log = LogManager.getLogger(Log4JDemo.class);
		log.info("this is my info message");
		log.error("This is error message");
		

	}

}
