package com.briup.service;


import java.util.List;

import com.briup.bean.Department;
import com.briup.bean.Position;

public interface IDepartmentService {
	List<Department> findAllDepartment();
	Department findDepartmentById(int id);
	Department findDepartmentByName(String name);
	List<Position> findPosition(Integer deptId);
}
