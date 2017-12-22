package com.huanggit.domain.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.huanggit.domain.entity.SubwayLineStation;
import redis.clients.jedis.BinaryClient;

@Mapper
public interface SubwayLineStationDao {
    int insert(@Param("pojo") SubwayLineStation pojo);

    int insertSelective(@Param("pojo") SubwayLineStation pojo);

    int insertList(@Param("pojos") List<SubwayLineStation> pojo);

    int update(@Param("pojo") SubwayLineStation pojo);

    List<SubwayLineStation> findSelective(@Param("pojo") SubwayLineStation pojo);

    List<SubwayLineStation> findByStationCode(@Param("stationCode") String stationCode);

    List<SubwayLineStation> findOpenByStationCode(@Param("stationCode") String stationCode);

    List<SubwayLineStation> findByLineNumberOrderByStationSortNumber(@Param("lineNumber") Integer lineNumber);
}
