package com.huanggit.service;

import com.huanggit.enumeration.subway.SubwayRideStrategy;
import com.huanggit.exception.BusinessException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import com.huanggit.domain.entity.SubwayLineStation;
import com.huanggit.domain.dao.SubwayLineStationDao;

@Service
public class SubwayLineStationService {

    @Resource
    private SubwayLineStationDao subwayLineStationDao;

    public int insert(SubwayLineStation pojo){
        return subwayLineStationDao.insert(pojo);
    }

    public int insertSelective(SubwayLineStation pojo){
        return subwayLineStationDao.insertSelective(pojo);
    }

    public int insertList(List<SubwayLineStation> pojos){
        return subwayLineStationDao.insertList(pojos);
    }

    public int update(SubwayLineStation pojo){
        return subwayLineStationDao.update(pojo);
    }


    public List<SubwayLineStation> rideWay(String stationCode1,String stationCode2,SubwayRideStrategy subwayRideStrategy) {
        List<SubwayLineStation> subwayLineStationList1 = subwayLineStationDao.findOpenByStationCode(stationCode1);
        if (subwayLineStationList1.isEmpty()) {
            throw new BusinessException("编号为"+stationCode1+"的地铁站不存在或未开通");
        }

        List<SubwayLineStation> subwayLineStationList2 = subwayLineStationDao.findOpenByStationCode(stationCode2);
        if (subwayLineStationList2.isEmpty()) {
            throw new BusinessException("编号为"+stationCode2+"的地铁站不存在或未开通");
        }

        List<SubwayLineStation> subwayLineStationResultList = new ArrayList<>();
        switch (subwayRideStrategy) {
            /**
             * 更少换乘
             */
            case LESS_TRANSFER:{
                /**
                 * 两个站在同一条线路上面
                 */
                for (SubwayLineStation subwayLineStation1 : subwayLineStationList1) {
                    for (SubwayLineStation subwayLineStation2 : subwayLineStationList2) {
                        if (subwayLineStation1.getLineNumber().equals(subwayLineStation2.getLineNumber())) {
                            int lineNumber = subwayLineStation1.getLineNumber();
                            int stationSortNumber1 = subwayLineStation1.getStationSortNumber();
                            int stationSortNumber2 = subwayLineStation2.getStationSortNumber();

                            stationSortNumber1 = (stationSortNumber1 < stationSortNumber2) ? stationSortNumber1 : stationSortNumber2;
                            stationSortNumber2 = (stationSortNumber1 < stationSortNumber2) ? stationSortNumber2 : stationSortNumber1;

                            List<SubwayLineStation> subwayLineStationList = subwayLineStationDao.findByLineNumberOrderByStationSortNumber(lineNumber);
                            for (int i = stationSortNumber1;i<=stationSortNumber2;i++) {
                                subwayLineStationResultList.add(subwayLineStationList.get(i));
                            }
                            return subwayLineStationResultList;
                        }
                    }
                }
                /**
                 * 两站不在同一条线路上面
                 */
                for (SubwayLineStation subwayLineStation1 : subwayLineStationList1) {

                }
                break;
            } default:{
                break;
            }
        }


        return null;
    }
}
