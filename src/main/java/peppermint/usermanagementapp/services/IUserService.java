package peppermint.usermanagementapp.services;

import peppermint.usermanagementapp.dto.UserDto;

public interface IUserService {
    UserDto save(UserDto user);

    UserDto findById(String id);
}
