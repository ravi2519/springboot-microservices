package com.ravi.department.service;

import com.ravi.department.entity.Department;
import com.ravi.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService( DepartmentRepository departmentRepository ) {
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment(Department department) {
        log.info("Saving the Department");
        return this.departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Getting department by id " + departmentId);
        return this.departmentRepository.findByDepartmentId(departmentId);
    }

}
