package com.huanggit.service.impl;

import com.huanggit.domain.dao.HeroDao;
import com.huanggit.domain.dao.HeroTypesDao;
import com.huanggit.domain.entity.Hero;
import com.huanggit.domain.repository.HeroRepository;
import com.huanggit.enumeration.hero.HeroType;
import com.huanggit.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huang on 2017-11-17-0017.
 */
@Service("heroService")
public class HeroServiceImpl implements HeroService {
    @Autowired
    private HeroRepository heroRepository;
    @Autowired
    private HeroTypesDao heroTypesDao;
    @Autowired
    private HeroDao heroDao;

    @Override
    public List<Hero> loadAll() {
        List<Hero> heroList = heroRepository.findAll();
        for (Hero hero : heroList) {
            hero.setHeroTypes(heroTypesDao.findTypesByHero(hero.getHeroCode()));
        }
        return heroList;
    }

    @Override
    public List<Hero> findByHeroType(HeroType heroType) {
        return heroDao.findByHeroType(heroType);
    }
}
