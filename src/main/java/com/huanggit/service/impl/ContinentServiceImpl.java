package com.huanggit.service.impl;

import com.huanggit.domain.entity.Continent;
import com.huanggit.domain.repository.ContinentRepository;
import com.huanggit.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huang on 2017-11-23-0023.
 */
@Service("continentService")
public class ContinentServiceImpl implements ContinentService {

    @Autowired
    private ContinentRepository continentRepository;

    @Override
    public List<Continent> loadAll() {
        return continentRepository.findAll();
    }
}
