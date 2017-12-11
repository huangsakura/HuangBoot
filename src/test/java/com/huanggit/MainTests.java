package com.huanggit;

import com.huanggit.domain.entity.Continent;
import com.huanggit.exception.BusinessException;
import com.huanggit.service.ContinentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {

	@Autowired
	private ContinentService continentService;

	@Test
	public void contextLoads() {

	}

	@Test
	public void testInsertApo() {
		Continent continent = new Continent();
		continent.setCode("ABB");
		continent.setName("AAsia");
		continent.setChineseName("压延州");
		continent.setCreateTime(new Date());
		try {
			continentService.insert(continent);
		} catch (BusinessException e) {
			log.error("{}",e.getMessage());
		}
	}
}
