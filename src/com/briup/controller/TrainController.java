package com.briup.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import com.briup.bean.Staff;
import com.briup.bean.Train;
import com.briup.bean.TrainType;
import com.briup.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.service.ITrainService;

@Controller
@RequestMapping("Tra")
public class TrainController {
	
	@Autowired
	private ITrainService trainService; 
	
	@RequestMapping("page")
	@ResponseBody
	public Map<String,Object> findTrainType(int pageNum, String name){
		Map<String,Object> m = new HashMap<>();
		m = trainService.findTrain(pageNum, name);
		m.put("status", 200);
		return m;
	}

    @RequestMapping("insert")
    @ResponseBody
    public Map<String, Object> insertTrain(String train2, java.util.Date Btime2, java.util.Date Etime2,Integer StaffId,Integer TrainId, Integer typeCode) throws MyException{
        java.sql.Date btime = new java.sql.Date(Btime2.getTime());
        java.sql.Date etime = new java.sql.Date(Etime2.getTime());
	    Train train = new Train();
        train.setType_code(typeCode);
        train.setTrain_expense(train2);
        train.setTrain_btime(btime);
        train.setTrain_etime(etime);
        train.setP_id(StaffId);
        train.setTrain_id(TrainId);
        System.out.println(train);
        Integer flag = trainService.insertTrain(train);
        Map<String, Object> map = new HashMap<String, Object>();
        if (flag == 2) {
            map.put("status", 200);
        } else if (flag == 1) {
            map.put("status", 300);
        } else{
            map.put("status", 301);
        }
        return map;
    }

    @RequestMapping("update")
    @ResponseBody
    public Map<String, Object> updateTrain(String train, java.util.Date Btime, java.util.Date Etime, Integer selectId) throws MyException {
        java.sql.Date btime = new java.sql.Date(Btime.getTime());
        java.sql.Date etime = new java.sql.Date(Etime.getTime());
        Train train1 = new Train();
        train1.setTrain_expense(train);
//        train.setType_code(typeCode);
//        train.setTrainType(trainType);
//        train.setStaff(staff);
        train1.setTrain_btime(btime);
        train1.setTrain_etime(etime);
        train1.setTrain_id(selectId);

        trainService.updateTrain(train1);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        return map;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> deleteTrain(Integer selectId) throws MyException{
        trainService.deleteTrain(selectId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        return map;
    }

}
