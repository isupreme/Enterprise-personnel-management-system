package com.briup.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.briup.bean.Staff;
import com.briup.bean.TrainType;
import com.briup.dao.StaffMapper;
import com.briup.dao.TrainTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Train;
import com.briup.dao.TrainMapper;
import com.briup.exception.MyException;
import com.briup.service.ITrainService;

@Service("trainService")
public class TrainServiceImpl implements ITrainService{
	
	@Autowired
	private TrainMapper trainDao;
	@Autowired
	private TrainTypeMapper trainTypeDao;
	@Autowired
	private StaffMapper staff;



	@Override
	public Map<String, Object> findTrain(int pageNum, String name) {
		// TODO Auto-generated method stub
		int pageSize = 5;  //每页显示的数量
		int begin = pageSize*(pageNum-1);
		int end = pageSize*pageNum;
		Map<String,Object> m = new HashMap<>();
		List<Train> allTrain = trainDao.queryTrain(name);
		List<Train> someTrain = new ArrayList<>();
		for (int i = begin; i < allTrain.size(); i++) {
			if(i == end)
				break;
			someTrain.add(allTrain.get(i));
		}
		m.put("list", someTrain);
		m.put("pageSize", Math.ceil((double)allTrain.size()/pageSize));
		return m;
	}



	@Override
	public void deleteTrain(Integer id) {
		// TODO Auto-generated method stub
        trainDao.deleteTrain(id);
	}



	@Override
	public void updateTrain(Train train) throws MyException {
		// TODO Auto-generated method stub
		trainDao.updateTrain(train);
	}



	@Override
	public Integer insertTrain(Train train) throws MyException {
		// TODO Auto-generated method stub
        int trainId = train.getType_code();
		int p_id = train.getP_id();
        System.out.println(trainId);

		TrainType trainTypeById = trainTypeDao.getTrainTypeById(trainId);
		Staff staffbyid=staff.findStaffById(p_id);
        System.out.println(trainTypeById);
        if (trainTypeById != null) {
//            System.out.println(train);
			if (staffbyid != null) {
				trainDao.insertTrain(train);
				return 2;
			}
            return 1;
        } else
        	{
            return 0;
        }
	}

}
