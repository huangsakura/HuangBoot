package com.huanggit.service.impl;

import com.huanggit.domain.dao.ContinentDao;
import com.huanggit.domain.entity.Continent;
import com.huanggit.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentServiceImpl implements ContinentService {

    @Autowired
    private ContinentDao continentDao;

    @Override
    public int insert(Continent pojo){
        return continentDao.insert(pojo);
    }

    @Override
    public int insertSelective(Continent pojo){
        return continentDao.insertSelective(pojo);
    }

    @Override
    public int insertList(List<Continent> pojos){
        return continentDao.insertList(pojos);
    }

    @Override
    public int update(Continent pojo){
        return continentDao.update(pojo);
    }

    @Override
    public List<Continent> load(String code,String name) {
        Continent continent = new Continent();
        continent.setCode(code);
        continent.setName(name);
        return continentDao.findSelective(continent);
    }
}
