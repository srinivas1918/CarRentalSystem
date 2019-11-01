package com.pramati.crs;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.pramati.crs.config.SweggerConfig;

@Import(SweggerConfig.class)
@SpringBootApplication
public class ProfileServiceApplication {

	public static void main(String[] args) {
		String[] cmdArgs = Arrays.copyOf(args, args.length+1);
		cmdArgs[args.length] = "-DLog4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector";
		SpringApplication.run(ProfileServiceApplication.class, cmdArgs);
	}

}
