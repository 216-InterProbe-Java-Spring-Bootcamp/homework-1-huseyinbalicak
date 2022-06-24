package com.interpobe.balicak.mapper;

import com.interpobe.balicak.dto.UserDto;
import com.interpobe.balicak.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final ModelMapper mapper;

    public UserMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public User convertToEntity (UserDto userDto)
    {

        return mapper.map(userDto, User.class);
    }

    public UserDto convertToDTO(User user)
    {
        return mapper.map(user, UserDto.class);
    }

}
