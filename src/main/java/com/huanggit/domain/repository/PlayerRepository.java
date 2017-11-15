package com.huanggit.domain.repository;

import com.huanggit.domain.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by huang on 2017-11-15-0015.
 */
public interface PlayerRepository extends JpaRepository<Player,Long> {
}
