package com.example.rest.service;

import com.example.rest.entity.Department;
import com.example.rest.exception.DepartmentExceptionRaBabu;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

   public Department fetchDepartmentById(Long id) throws DepartmentExceptionRaBabu;

   public void deleteDepartmentById(Long id);

   public Department updateDepartment(Long id, Department hi);

    public Department fetchDepartmentByName(String name);
}
