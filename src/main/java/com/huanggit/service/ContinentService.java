package com.huanggit.service;

import com.huanggit.domain.repository.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.huanggit.domain.entity.Continent;

@Service
public class ContinentService {

    @Autowired
    private ContinentRepository continentRepository;

    public int insert(Continent pojo){
        return continentRepository.insert(pojo);
    }

    public int insertSelective(Continent pojo){
        return continentRepository.insertSelective(pojo);
    }

    public int insertList(List<Continent> pojos){
        return continentRepository.insertList(pojos);
    }

    public int update(Continent pojo){
        return continentRepository.update(pojo);
    }

    public List<Continent> findAll() {
        return continentRepository.findAll();
    }
}
