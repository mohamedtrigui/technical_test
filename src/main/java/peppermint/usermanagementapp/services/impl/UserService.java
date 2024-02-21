package peppermint.usermanagementapp.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import peppermint.usermanagementapp.dao.UserDao;
import peppermint.usermanagementapp.dto.UserDto;
import peppermint.usermanagementapp.entities.User;
import peppermint.usermanagementapp.mappers.UserMapper;
import peppermint.usermanagementapp.services.IUserService;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserDao userDao;

    private final UserMapper userMapper;

    /**
     * This method to save the new user.
     *
     * @param user
     * @return user created
     */
    public UserDto save(UserDto user) {
        User newUser = this.userDao.save(this.userMapper.toEntity(user));
        return this.userMapper.toDto(newUser);
    }

    /**
     * This method find a user by its id.
     *
     * @param id of the user
     * @return user object
     */
    public UserDto findById(String id) throws IllegalArgumentException {
        User user = userDao.findById(id).orElse(null);
        return this.userMapper.toDto(user);
    }
}
