package com.huanggit.service;

import com.huanggit.domain.entity.Hero;

import java.util.List;

/**
 * Created by huang on 2017-11-17-0017.
 */
public interface HeroService {

    List<Hero> loadAll();
}
