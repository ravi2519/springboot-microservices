package com.ravi.user.controller;

import com.ravi.user.entity.User;
import com.ravi.user.service.UserService;
import com.ravi.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Saving User " + user.toString());
        return this.userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment( @PathVariable("id") Long userId) {
        log.info("Getting User with department for user " + userId);
        return this.userService.getUserWithDepartment(userId);
    }

}
