package com.huanggit.service;

import com.huanggit.enumeration.subway.SubwayRideStrategy;
import java.util.List;
import com.huanggit.domain.entity.SubwayLineStation;

public interface SubwayLineStationService {

    public int insert(SubwayLineStation pojo);

    public int insertSelective(SubwayLineStation pojo);

    public int insertList(List<SubwayLineStation> pojos);

    public int update(SubwayLineStation pojo);

    public List<SubwayLineStation> rideWay(String stationCode1,String stationCode2,SubwayRideStrategy subwayRideStrategy);
}
