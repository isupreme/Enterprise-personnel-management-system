package com.briup.service;


import com.briup.bean.Train;
import com.briup.exception.MyException;

import java.util.Map;

public interface ITrainService {
    void deleteTrain(Integer id);
    void updateTrain(Train train) throws MyException;
    Integer insertTrain(Train train) throws MyException;
	Map<String, Object> findTrain(int pageNum, String name);
}
