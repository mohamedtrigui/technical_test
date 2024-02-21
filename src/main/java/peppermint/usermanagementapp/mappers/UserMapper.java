package peppermint.usermanagementapp.mappers;

import org.springframework.stereotype.Component;
import peppermint.usermanagementapp.dto.UserDto;
import peppermint.usermanagementapp.entities.User;

import java.util.Objects;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        if (Objects.isNull(user)) {
            return null;
        }
        return UserDto.builder()
                .address(user.getAddress())
                .country(user.getCountry())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .age(user.getAge())
                .password(user.getPassword())
                .build();
    }

    public User toEntity(UserDto userDto) {
        if (Objects.isNull(userDto)) {
            return null;
        }
        return User.builder()
                .address(userDto.getAddress())
                .country(userDto.getCountry())
                .fullName(userDto.getFullName())
                .email(userDto.getEmail())
                .age(userDto.getAge())
                .password(userDto.getPassword())
                .build();
    }
}
