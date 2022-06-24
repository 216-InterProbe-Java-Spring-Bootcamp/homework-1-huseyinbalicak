package com.interpobe.balicak.api;

import com.interpobe.balicak.dto.UserDto;
import com.interpobe.balicak.entity.User;
import com.interpobe.balicak.mapper.UserMapper;
import com.interpobe.balicak.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping()
    public List<UserDto> all() {

        var users = userService.getAllUsers();

        List<UserDto> userDtos = new ArrayList<>();
        for(User user : users)
        {
            userDtos.add(userMapper.convertToDTO(user));
        }
        return userDtos;

    }

}
