package com.huanggit.domain.repository;

import com.huanggit.domain.entity.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by huang on 2017-11-23-0023.
 */
public interface ContinentRepository extends JpaRepository<Continent,Long> {
}
