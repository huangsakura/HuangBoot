package com.huanggit.service.impl;

import com.huanggit.domain.dao.CountryDao;
import com.huanggit.domain.entity.Country;
import com.huanggit.service.CountryService;
import com.huanggit.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Resource
    private CountryDao countryDao;

    @Override
    public int insert(Country pojo){
        return countryDao.insert(pojo);
    }

    @Override
    public int insertSelective(Country pojo){
        return countryDao.insertSelective(pojo);
    }

    @Override
    public int insertList(List<Country> pojos){
        return countryDao.insertList(pojos);
    }

    @Override
    public int update(Country pojo){
        return countryDao.update(pojo);
    }

    @Override
    public List<Country> find() {
        Country country = new Country();
        country.setNationalDay(DateUtil.igoreTime(1949,10,1));
        return countryDao.findSelective(country);
    }
}
