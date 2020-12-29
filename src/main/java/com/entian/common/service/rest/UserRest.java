package com.entian.common.service.rest;

import com.entian.common.service.entity.UserEntity;
import com.entian.common.service.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jianggangli
 * @version 1.0 2020/12/28 16:33
 * 功能:
 */
@RestController
public class UserRest {
    @Autowired
    private UserService userService;


    @ApiOperation("入参校验例子")
    @GetMapping("/selectList")
    public List<UserEntity> selectList() {
        List<UserEntity> userList = userService.list();
        userList.forEach(System.out::println);
        return userList;
    }

}
