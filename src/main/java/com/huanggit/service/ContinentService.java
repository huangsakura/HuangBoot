package com.huanggit.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.huanggit.domain.entity.Continent;
import com.huanggit.domain.dao.ContinentDao;

@Service
public class ContinentService {

    @Resource
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
