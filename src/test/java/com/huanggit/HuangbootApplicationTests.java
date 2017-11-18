package com.huanggit;

import com.huanggit.enumeration.player.Gender;
import com.huanggit.service.PlayerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HuangbootApplicationTests {

	@Autowired
	private PlayerService playerService;

	@Test
	public void contextLoads() {

		playerService.register("13290036155","111111",null, Gender.FEMALE);
	}

}
