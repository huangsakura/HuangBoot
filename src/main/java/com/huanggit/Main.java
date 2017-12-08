package com.huanggit;

import com.huanggit.domain.repository.base.BaseJpaRepositoryBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseJpaRepositoryBean.class
		,queryLookupStrategy = QueryLookupStrategy.Key.USE_DECLARED_QUERY)
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
