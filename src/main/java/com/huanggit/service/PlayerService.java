package com.huanggit.service;

import com.huanggit.domain.entity.Player;
import com.huanggit.enumeration.player.Gender;

/**
 * Created by huang on 2017-11-15-0015.
 */
public interface PlayerService {

    Player register(String mobile,String password, String nickName,Gender gender);
}
