package com.huanggit;

import com.huanggit.domain.entity.Continent;
import com.huanggit.domain.entity.Country;
import com.huanggit.exception.BusinessException;
import com.huanggit.service.ContinentService;
import com.huanggit.service.CountryService;
import com.huanggit.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {

	@Autowired
	private ContinentService continentService;
	@Autowired
	private CountryService countryService;

	@Test
	public void contextLoads() {

	}

	@Test
	public void testInsertApo() {
		Continent continent = new Continent();
		continent.setCode("AC");
		continent.setName("AAsia");
		continent.setChineseName("压延州压延州压延州压延州压延州压延州压延");
		continent.setCreateTime(new Date());
		try {
			continentService.insert(continent);
		} catch (BusinessException e) {
			log.error("{}",e.getMessage());
		}
	}

	@Test
	public void testCountryInsert() {
		Country country = new Country();
		country.setAlpha2Code("FR");
		country.setAlpha3Code("FRA");
		country.setName("France");
		country.setCapitalName("Paris");
		country.setContinentCode("EU");
		country.setNationalDay(DateUtil.igoreTime(1945,7,14));
		try {
			countryService.insert(country);
		} catch (BusinessException e) {
			log.error("{}",e.getMessage());
		}
	}
}
