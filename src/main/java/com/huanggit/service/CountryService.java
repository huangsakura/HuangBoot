package com.huanggit.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;
import com.huanggit.domain.entity.Country;
import com.huanggit.domain.dao.CountryDao;

@Service
public class CountryService{

    @Resource
    private CountryDao countryDao;

    public int insert(Country pojo){
        return countryDao.insert(pojo);
    }

    public int insertSelective(Country pojo){
        return countryDao.insertSelective(pojo);
    }

    public int insertList(List<Country> pojos){
        return countryDao.insertList(pojos);
    }

    public int update(Country pojo){
        return countryDao.update(pojo);
    }

    public List<Country> find() {
        Country country = new Country();
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR,0);
        today.set(Calendar.MINUTE,0);
        today.set(Calendar.SECOND,0);
        //country.setNationalDay(today.getTime());
        return countryDao.findSelective(country);
    }
}
