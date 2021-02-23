package com.ravi.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/userServiceFallback")
    public String userServiceFallbackMethod() {
        return "User service is taking longer than expected." +
                " Please try again later!";
    }

    @GetMapping("/departmentServiceFallback")
    public String departmentServiceFallbackMethod() {
        return "Department service is taking longer than expected." +
                " Please try again later!";
    }

}
