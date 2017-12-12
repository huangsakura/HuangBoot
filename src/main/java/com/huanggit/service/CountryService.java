package com.huanggit.service;

import com.huanggit.util.DateUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.huanggit.domain.entity.Country;
import com.huanggit.domain.dao.CountryDao;

@Service
public class CountryService {

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
        country.setNationalDay(DateUtil.igoreTime(1949,10,1));
        return countryDao.findSelective(country);
    }
}
