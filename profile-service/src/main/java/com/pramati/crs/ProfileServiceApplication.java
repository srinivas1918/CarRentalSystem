package com.pramati.crs;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfileServiceApplication {

	public static void main(String[] args) {
		String[] extededArgs = Arrays.copyOf(args, args.length+1);
		extededArgs[args.length] = "-DLog4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector";
		SpringApplication.run(ProfileServiceApplication.class, extededArgs);
	}

}
