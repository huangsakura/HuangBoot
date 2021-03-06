package com.huanggit;

import com.huanggit.domain.entity.Account;
import com.huanggit.domain.entity.Continent;
import com.huanggit.domain.entity.Country;
import com.huanggit.exception.BusinessException;
import com.huanggit.general.dto.common.Money;
import com.huanggit.service.AccountService;
import com.huanggit.service.ContinentService;
import com.huanggit.service.CountryService;
import com.huanggit.util.DateUtil;
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
	@Autowired
	private CountryService countryService;
	@Autowired
	private AccountService accountService;

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

	@Test
	public void testAccountInsert() {
		Account account = new Account();
		account.setCountryAlpha3Code("CHN");
		account.setAmount(Money.cent(10000L));
		accountService.insert(account);
	}
}
