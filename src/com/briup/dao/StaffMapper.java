package com.briup.dao;

import java.util.HashMap;
import java.util.List;

import com.briup.bean.Page;
import com.briup.bean.Staff;
import org.apache.ibatis.annotations.Param;

public interface StaffMapper extends BaseDao<Staff>{
	
    List<Staff> queryAll(HashMap<String,Object> map);
    Integer sum();
    void deleteStaff(int id);
//    void updateStaff(int id,String name,String sex,String degree,String department,String position,String state,String username,String password);
//    void insertStaff(String name,String sex,String degree,Integer department,Integer position,String state,String username,String password);
    void updateStaff(Staff staff);
    void insertStaff(Staff staff);
    List<Staff> checkUser(Staff staff);
    List<Staff> AgrCheck(HashMap<String,Object> map);
    String selectName(String username);
    Staff findStaffById(int id);
    List<Staff> findAllStaff(@Param("name") String name);
    List<Staff> findStaffByName(String name);
}
