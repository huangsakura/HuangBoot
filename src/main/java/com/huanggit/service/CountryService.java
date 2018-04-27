package com.huanggit.service;

import java.util.List;
import com.huanggit.domain.entity.Country;

public interface CountryService {

    public int insert(Country pojo);

    public int insertSelective(Country pojo);

    public int insertList(List<Country> pojos);

    public int update(Country pojo);

    public List<Country> find();
}
