package com.huanggit.domain.repository;

import com.huanggit.domain.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by huang on 2017-11-17-0017.
 */
public interface HeroRepository extends JpaRepository<Hero,Long> {
}
