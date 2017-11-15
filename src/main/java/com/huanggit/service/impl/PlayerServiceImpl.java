package com.huanggit.service.impl;

import com.huanggit.domain.entity.Player;
import com.huanggit.domain.repository.PlayerRepository;
import com.huanggit.enumeration.player.Gender;
import com.huanggit.service.PlayerService;
import com.huanggit.util.DateUtil;
import com.huanggit.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * Created by huang on 2017-11-15-0015.
 */
@Service(value = "playerService")
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player register(String mobile, String password, String nickName,Gender gender) {
        Player player = new Player();
        player.setMobile(mobile);
        player.setGender(gender);
        player.setPassword(password);
        player.setPasswordSalt(DateUtil.format(new Date(), DateUtil.DateFormatPattern.DATETIME_NOT_SEPARATOR));
        playerRepository.save(player);
        player.setPlayerCode(RandomUtil.prefixCode(4)+DateUtil.format(new Date(), DateUtil.DateFormatPattern.DATE_NOT_SEPARATOR)+player.getId());
        if (StringUtils.isEmpty(nickName)) {
            player.setNickName(player.getPlayerCode());
        } else {
            player.setNickName(nickName);
        }
        playerRepository.save(player);
        return player;
    }
}
