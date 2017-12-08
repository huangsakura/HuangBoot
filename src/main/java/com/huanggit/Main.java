package com.huanggit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Main implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication();
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(Main.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		log.info("http://127.0.0.1:8092");
	}
}
