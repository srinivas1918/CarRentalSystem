package com.pramati.crs.booking;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingServiceApplication {

	public static void main(String[] args) {
		String[] extendedArgs = Arrays.copyOf(args, args.length+1);
		extendedArgs[args.length] = "-DLog4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector";
		SpringApplication.run(BookingServiceApplication.class, extendedArgs);
	}

}
