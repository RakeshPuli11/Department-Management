package com.example.rest.service;

import com.example.rest.entity.Department;
import com.example.rest.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository dr;


    @BeforeEach
    void setUp() {// here we need to mock the repository using objects
        // so we are using builder
        Department dpp = Department.builder().departmentAddress("kmm").build();
        Mockito.when(dr.fetchDepartmentByName("IOT")).thenReturn(dpp);
    }
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String DepartmentNameExample = "IOT";
        Department x = departmentService.fetchDepartmentByName(DepartmentNameExample);
        assertEquals(DepartmentNameExample,x.getDepartmentName());
    }
}