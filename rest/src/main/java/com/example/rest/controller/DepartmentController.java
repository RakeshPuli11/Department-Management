package com.example.rest.controller;

import com.example.rest.entity.Department;
import com.example.rest.exception.DepartmentExceptionRaBabu;
import com.example.rest.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    //here Requestbody is used for http requests to convert the json object to department type
    @PostMapping("/saveDepartment")
    public Department saveDepartment(@RequestBody Department department){
      //  DepartmentService service = new DepartmentServiceClass();
    // in spring boot we don't do this classic type object creation
    return departmentService.saveDepartment(department);
    }

    @GetMapping("/getDepartments")
    public List<Department> departmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/deptById/{id}")
    public Department fetchDepartment(@PathVariable("id") Long id) throws DepartmentExceptionRaBabu {
        return departmentService.fetchDepartmentById(id);
    }

    @DeleteMapping("/deleteDept/{id}")
    public String deleteDepartment(@PathVariable("id") Long id){
         departmentService.deleteDepartmentById(id);
        return "deleted";
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department hi){
        return departmentService.updateDepartment(id,hi);
    }
    @GetMapping("/update/hi/op/{name}")// usefull
    public Department fetchDepartmentByName(@Valid @PathVariable("name") String name){
        return departmentService.fetchDepartmentByName(name);
    }
}
