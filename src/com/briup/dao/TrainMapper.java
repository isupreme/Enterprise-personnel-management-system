package com.briup.dao;

import com.briup.bean.Train;

import java.util.HashMap;
import java.util.List;

import com.briup.bean.TrainType;
import org.apache.ibatis.annotations.Param;

public interface TrainMapper {
    List<Train> queryTrain(@Param("name") String name);
    Integer sum();
    void deleteTrain(Integer id);
    void updateTrain(Train train);
    void insertTrain(Train train);
    Train getTrainById( Integer id);
}
