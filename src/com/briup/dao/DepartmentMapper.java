package com.briup.dao;

import java.util.List;

import com.briup.bean.Department;
import com.briup.bean.Position;

public interface DepartmentMapper {

	List<Department> findAllDep();
	Department findDepByName(String name) ;
	Department findDepById(int id) ;
	List<Position> findPosition(Integer deptId);
}
