package com.ravi.department.controller;

import com.ravi.department.entity.Department;
import com.ravi.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}")
    public Department findDepartment(@PathVariable("id") Long departmentId ) {
        log.info("Find department controller endpoint for " + departmentId);
        return this.departmentService.findDepartmentById(departmentId);
    }

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Saving Department endpoint" + department.toString());
        return  this.departmentService.saveDepartment(department);
    }

}
