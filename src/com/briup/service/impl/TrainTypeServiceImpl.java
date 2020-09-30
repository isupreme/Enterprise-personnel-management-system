package com.briup.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.TrainType;
import com.briup.dao.TrainTypeMapper;
import com.briup.exception.MyException;
import com.briup.service.ITrainTypeService;

@Service("trainTypeService")
public class TrainTypeServiceImpl implements ITrainTypeService {

    @Autowired
    private TrainTypeMapper trainTypeDao;

    @Override
    public boolean TrainCheck(HashMap<String, Object> map) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void deleteTrainType(Integer id) throws MyException {
        // TODO Auto-generated method stub
        trainTypeDao.deleteTrainType(id);
    }

    @Override
    public void updateTrainType(TrainType trainType) throws MyException {
        // TODO Auto-generated method stub
        trainTypeDao.updateTrainType(trainType);
    }

    @Override
    public Integer inserTrainType(TrainType trainType) throws MyException {
        // TODO Auto-generated method stub
        int trainTypeId = trainType.getType_code();
        TrainType trainTypeById = trainTypeDao.getTrainTypeById(trainTypeId);
        if (trainTypeById == null) {
            trainTypeDao.insertTrainType(trainType);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Map<String, Object> findTrainType(int pageNum, String name) {
        // TODO Auto-generated method stub
        int pageSize = 5;  //每页显示的数量
        int begin = pageSize * (pageNum - 1);
        int end = pageSize * pageNum;
        Map<String, Object> m = new HashMap<>();
        List<TrainType> allTrainType = trainTypeDao.queryTrainType(name);
        List<TrainType> someTrainType = new ArrayList<>();
        for (int i = begin; i < allTrainType.size(); i++) {
            if (i == end)
                break;
            someTrainType.add(allTrainType.get(i));
        }
        m.put("list", someTrainType);
        m.put("pageSize", Math.ceil((double) allTrainType.size() / pageSize));
        return m;
    }

}
