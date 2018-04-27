package com.huanggit.service;

import java.util.List;
import com.huanggit.domain.entity.Continent;

public interface ContinentService {

    public int insert(Continent pojo);

    public int insertSelective(Continent pojo);

    public int insertList(List<Continent> pojos);

    public int update(Continent pojo);

    public List<Continent> load(String code,String name);
}
