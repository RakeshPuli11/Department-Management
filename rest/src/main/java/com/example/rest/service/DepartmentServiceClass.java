package com.example.rest.service;

import com.example.rest.entity.Department;
import com.example.rest.exception.DepartmentExceptionRaBabu;
import com.example.rest.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceClass implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long id) throws DepartmentExceptionRaBabu {
       // return departmentRepository.findById(id).get();
        Optional<Department> department = departmentRepository.findById(id);
        if(!department.isPresent()){
            throw new DepartmentExceptionRaBabu("em ledu bro atlantidhi");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    };

    @Transactional
    public Department updateDepartment(Long id, Department hi) {
        Department dprt = departmentRepository.findById(id).get();
        if (Objects.nonNull(hi.getDepartmentName()) && !"".equalsIgnoreCase(hi.getDepartmentName())) {
            dprt.setDepartmentName(hi.getDepartmentName());
        }
        if (Objects.nonNull(hi.getDepartmentCode()) && !"".equalsIgnoreCase(hi.getDepartmentCode())) {
            dprt.setDepartmentCode(hi.getDepartmentCode());
        }
        if (Objects.nonNull(hi.getDepartmentAddress()) && !"".equalsIgnoreCase(hi.getDepartmentAddress())) {
            dprt.setDepartmentAddress(hi.getDepartmentAddress());
        }
        return departmentRepository.save(dprt);
    }
    // if (hi.getDepartmentName() != null && !hi.getDepartmentName().isEmpty()) {
    // // Code block
    // }
    // we can also use this statemenet instead of above if
    @Override
    public Department fetchDepartmentByName(String name) {
        return departmentRepository.fetchDepartmentByName(name);
    }


}
