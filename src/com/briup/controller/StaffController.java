package com.briup.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Staff;
import com.briup.exception.MyException;
import com.briup.service.IStaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	private IStaffService staffService;

	@RequestMapping("/login")
	public String login(Staff staff) {
		System.out.println(staff);
			if(staffService.exist(staff)) {
				System.out.println("员工登录");
			}else {
				System.out.println("不存在该员工！");
			}
		return "index";
	}
	
	@RequestMapping("/findAllStaff") //staff/findAllStaff
	@ResponseBody
	public Map<String,Object> findAllStaff(int pageNum,String name) {
		Map<String,Object> m;
//		if(name.equals(null)||name.equals("")) {
//        if(name==null||name.equals("")) {
			m = staffService.findAllStaff(pageNum,name);
//		}else {
//			m = staffService.findStaffByName(name);
//		}
		return m;
	}
	
	@RequestMapping("/deleteStaff")
	@ResponseBody
	public Map<String,Object> delectStaff(int StaffId){
		System.out.println(StaffId);
		Map<String,Object> m = new HashMap<>();
		staffService.deleteStaff(StaffId);
		m.put("status", 200);
		return m;
	}
	
	@RequestMapping("/updateStaff")
	@ResponseBody
	public Map<String,Object> updateStaff(int id, String name, String sex, String degree, Integer department, Integer position, String state, String username, String password) {
		System.out.println(id+","+name+","+sex+","+degree+","+department+","+position+","+state+","+username+","+password);
//		d.setDept_name(department);
        Staff s = new Staff();
//        s.setId(20);
//		s.setName("ccc");
//		s.setSex("女");
//		s.setDegree("本科");
//		s.setDeptId(2);
//		s.setPosId(4);
//		s.setState("在职");
//		s.setUsername("123");
//		s.setPassword("123");
        s.setId(id);
        s.setName(name);
        s.setSex(sex);
        s.setDegree(degree);
        s.setDeptId(department);
        s.setPosId(position);
        s.setState(state);
        s.setUsername(username);
        s.setPassword(password);
		staffService.updateStaff(s);

//		staffService.updateStaff(id,name,sex,degree,department,position,state,username,password);

		Map<String,Object> m = new HashMap<>();
		m.put("status", 200);
		return m;
	}
	
//	@RequestMapping("/insertStaff")
//	@ResponseBody
//	public Map<String,Object> insertStaff(String name,String sex,String degree,Integer department,Integer position,String state,String username,String password) throws MyException, Exception {
//        System.out.println(name);
//        System.out.println(department);
//        System.out.println(position);
//	    staffService.insertStaff(name,sex,degree,department,position,state,username,password);
//		Map<String,Object> m = new HashMap<>();
//		m.put("status", 200);
//		return m;
//	}
    @RequestMapping("/insertStaff")
    @ResponseBody
    public Map<String,Object> insertStaff(Staff staff) throws MyException, Exception {
//        Staff staff1 = new Staff();
//        staff1.setName("小号");
//        staff1.setSex("男");
//        staff1.setDegree("本科");
//        staff1.setDeptId(3);
//        staff1.setPosId(3);
//        staff1.setState("在职");
//        staff1.setUsername("asd");
//        staff1.setPassword("123");
        System.out.println(staff.getPosId());
        System.out.println(staff.getDeptId());
        staffService.insertStaff(staff);
        Map<String,Object> m = new HashMap<>();
        m.put("status", 200);
        return m;
    }
}
