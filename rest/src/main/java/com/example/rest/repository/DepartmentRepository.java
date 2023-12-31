package com.example.rest.repository;

import com.example.rest.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query(value = "select * from DEPARTMENT where DEPARTMENT_NAME = :name",nativeQuery = true)
    public Department fetchDepartmentByName(@Param("name") String name);
}
