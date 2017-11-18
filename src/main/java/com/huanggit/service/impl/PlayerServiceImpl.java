package com.huanggit.service.impl;

import com.huanggit.domain.entity.Player;
import com.huanggit.domain.repository.PlayerRepository;
import com.huanggit.enumeration.common.Country;
import com.huanggit.enumeration.common.ResultCode;
import com.huanggit.enumeration.player.Gender;
import com.huanggit.exception.BusinessException;
import com.huanggit.service.PlayerService;
import com.huanggit.util.DateUtil;
import com.huanggit.util.RandomUtil;
import com.huanggit.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by huang on 2017-11-15-0015.
 */
@Slf4j
@Service(value = "playerService")
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String REGISTER_REDIS_PREFIX = "REGISTER_REDIS_PREFIX_";

    private static final int SALT_SIZE = 8;

    private static final int HASH_INTERATIONS = 512;

    @Override
    public Player register(String mobile, String password, String nickName,Gender gender) {
        Player player = new Player();
        player.setMobile(mobile);
        player.setGender(gender);
        player.setPasswordSalt(RandomUtil.randomString(SALT_SIZE));
        player.setPassword(Hex.encodeHexString(SecurityUtil.sha1(password.getBytes(), player.getPasswordSalt().getBytes(), HASH_INTERATIONS)));
        Country country = null;
        do {
            country = RandomUtil.randomCountry();
        } while (null != stringRedisTemplate.opsForValue().get(REGISTER_REDIS_PREFIX + country.getSimplfiedCode()));
        stringRedisTemplate.opsForValue().set(REGISTER_REDIS_PREFIX + country.getSimplfiedCode()
                ,country.getSimplfiedCode(),1L, TimeUnit.SECONDS);
        player.setPlayerCode(country.getSimplfiedCode()+DateUtil.format(new Date(), DateUtil.DateFormatPattern.DATETIME_NOT_SEPARATOR));
        player.setCountry(country);
        if (StringUtils.isEmpty(nickName)) {
            player.setNickName(player.getPlayerCode());
        } else {
            player.setNickName(nickName);
        }
        try {
            playerRepository.save(player);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(ResultCode.MOBILE_EXISTED);
        } catch (Exception e) {
            log.error("手机号{}注册失败:{}",mobile,e.getMessage());
            throw new BusinessException("注册失败",ResultCode.OTHER);
        }
        return player;
    }

    @Override
    public Player login(String mobile, String password) {
        Player player = new Player();
        player.setMobile(mobile);
        player.setPassword(password);

        Example<Player> playerExample = Example.of(player, ExampleMatcher.matching());
        List<Player> playerList = playerRepository.findAll(playerExample);
        if (!playerList.isEmpty()) {
            return playerList.get(0);
        } else {
            throw new BusinessException(ResultCode.PLAYER_NOT_EXIST);
        }
    }
}
