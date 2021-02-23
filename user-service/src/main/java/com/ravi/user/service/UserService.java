package com.ravi.user.service;

import com.ravi.user.entity.User;
import com.ravi.user.repository.UserRepository;
import com.ravi.user.vo.Department;
import com.ravi.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    private UserRepository userRepository;
    private RestTemplate restTemplate;

    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }


    public User saveUser(User user) {
        log.info("Saving user in Service");
        return this.userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Getting user with department from service");
        User user = this.userRepository.findByUserId(userId);
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        responseTemplateVO.setUser(user);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
                        Department.class);

        responseTemplateVO.setDepartment(department);

        return responseTemplateVO;

    }
}
