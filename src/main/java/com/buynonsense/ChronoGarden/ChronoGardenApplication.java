package com.buynonsense.ChronoGarden;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 确保这个注解存在
public class ChronoGardenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChronoGardenApplication.class, args);
	}

}
