package com.briup.controller;

import java.util.HashMap;
import java.util.Map;

import com.briup.bean.TrainType;
import com.briup.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.briup.service.ITrainTypeService;

@Controller
@RequestMapping("Type")
public class TrainTypeController {

    @Autowired
    private ITrainTypeService trainTypeService;

    @RequestMapping("page")
    @ResponseBody
    public Map<String, Object> findTrainType(int pageNum, String name) {
        Map<String, Object> m = new HashMap<>();
        m = trainTypeService.findTrainType(pageNum, name);
        m.put("status", 200);
        return m;
    }

    @RequestMapping("insert")
    @ResponseBody
    public Map<String, Object> insertTrainType(String typeName, String typeInfo, Integer typeCode) throws MyException{
        TrainType trainType = new TrainType();
        trainType.setType_code(typeCode);
        trainType.setType_name(typeName);
        trainType.setType_info(typeInfo);
        Integer flag = trainTypeService.inserTrainType(trainType);
        Map<String, Object> map = new HashMap<String, Object>();
        if (flag == 1) {
            map.put("status", 200);
        } else {
            map.put("status", 300);
        }
        return map;
    }

    @RequestMapping("update")
    @ResponseBody
    public Map<String, Object> updateTrainType(String typename, String typeinfo, Integer selectId) throws MyException{
        TrainType trainType = new TrainType();
        trainType.setType_code(selectId);
        trainType.setType_name(typename);
        trainType.setType_info(typeinfo);
        trainTypeService.updateTrainType(trainType);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        return map;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> deleteTrainType(Integer TypeId) throws MyException{
        trainTypeService.deleteTrainType(TypeId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        return map;
    }

}
