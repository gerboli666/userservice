package com.geriz.userservice.service;

import com.geriz.userservice.VO.Deparment;
import com.geriz.userservice.VO.ResponseTemplateVO;
import com.geriz.userservice.entity.User;
import com.geriz.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    public User saveUser(User user) {
        log.info("Inside saveUser UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside saveUser UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Deparment deparment =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departmens/" +
                user.getDepartmentId(), Deparment.class);
        vo.setUser(user);
        vo.setDeparment(deparment);
        return vo;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
