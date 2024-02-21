package peppermint.usermanagementapp.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import peppermint.usermanagementapp.dto.UserDto;
import peppermint.usermanagementapp.entities.User;
import peppermint.usermanagementapp.services.impl.UserService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {
    
    @InjectMocks
    private UserMapper userMapper;

    @Test
    void toDto() {
        User user = User.builder()
                .id("1")
                .fullName("test")
                .age(22)
                .email("test@test.com")
                .country("France")
                .address("nice")
                .password("test")
                .build();
        UserDto userDto = this.userMapper.toDto(user);
        Assertions.assertEquals("test", userDto.getFullName());
        Assertions.assertEquals("test@test.com", userDto.getEmail());
        Assertions.assertEquals("France", userDto.getCountry());
        Assertions.assertEquals("nice", userDto.getAddress());
        Assertions.assertEquals("test", userDto.getPassword());
        Assertions.assertEquals(22, userDto.getAge());
    }

    @Test
    void toEntity() {
        UserDto userDto = UserDto.builder()
                .fullName("test")
                .age(22)
                .email("test@test.com")
                .country("France")
                .address("nice")
                .password("test")
                .build();
        User user = this.userMapper.toEntity(userDto);
        Assertions.assertEquals("test", user.getFullName());
        Assertions.assertEquals("test@test.com", user.getEmail());
        Assertions.assertEquals("France", user.getCountry());
        Assertions.assertEquals("nice", user.getAddress());
        Assertions.assertEquals("test", user.getPassword());
        Assertions.assertEquals(22, user.getAge());
    }

    @Test
    void toDtoWhenNull() {
        UserDto userDto = this.userMapper.toDto(null);
        Assertions.assertNull(userDto);
    }

    @Test
    void toEntityWhenNull() {
        User user = this.userMapper.toEntity(null);
        Assertions.assertNull(user);
    }
}