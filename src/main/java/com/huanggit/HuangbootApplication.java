package com.huanggit;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HuangbootApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication();
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(HuangbootApplication.class, args);
	}
}
