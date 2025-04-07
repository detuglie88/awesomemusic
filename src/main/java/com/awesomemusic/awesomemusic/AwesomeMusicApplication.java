package com.awesomemusic.awesomemusic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j(topic = "trace")
public class AwesomeMusicApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(AwesomeMusicApplication.class, args);
			log.info("Application started");
		} catch (Exception e) {
			log.error("ERROR START APPLICATION", e);
		}
	}

}
