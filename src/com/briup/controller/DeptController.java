package com.briup.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.briup.bean.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Department;
import com.briup.service.IDepartmentService;

@Controller
@RequestMapping("/manage")
public class DeptController {
	
	@Autowired
	private IDepartmentService deptService;

	@RequestMapping("/cascade")
	@ResponseBody
	public Map<String,Object> findAllDept(){
		Map<String,Object> map = new HashMap<>();
		List<Department> list = deptService.findAllDepartment();
        System.out.println(list);
		map.put("pos", list);
		return map;
	}
	
	@RequestMapping("/position")
	@ResponseBody
	public Map<String,Object> findPosition(Integer deptId){
		System.out.println("deptId"+deptId);
		Map<String,Object> map = new HashMap<>();
		List<Position> position = deptService.findPosition(deptId);
//        System.out.println(position.get(0).getPOS_NAME());
        System.out.println(position);
		map.put("pos", position);
		return map;
	}
}
