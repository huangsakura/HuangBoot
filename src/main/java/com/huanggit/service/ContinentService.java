package com.huanggit.service;

import com.huanggit.domain.dao.ContinentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.huanggit.domain.entity.Continent;

@Service
public class ContinentService {

    @Autowired
    private ContinentDao continentDao;

    public int insert(Continent pojo){
        return continentDao.insert(pojo);
    }

    public int insertSelective(Continent pojo){
        return continentDao.insertSelective(pojo);
    }

    public int insertList(List<Continent> pojos){
        return continentDao.insertList(pojos);
    }

    public int update(Continent pojo){
        return continentDao.update(pojo);
    }

    public List<Continent> findAll() {
        return continentDao.findAll();
    }
}
