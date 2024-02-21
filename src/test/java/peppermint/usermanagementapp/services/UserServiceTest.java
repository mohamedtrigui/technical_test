package peppermint.usermanagementapp.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import peppermint.usermanagementapp.dao.UserDao;
import peppermint.usermanagementapp.dto.UserDto;
import peppermint.usermanagementapp.entities.User;
import peppermint.usermanagementapp.mappers.UserMapper;
import peppermint.usermanagementapp.services.impl.UserService;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService userServiceMock;

    @Mock
    private UserDao userDaoMock;

    @Mock
    private UserMapper userMapper;

    @Test
    void saveTest() {
        User userMock = User.builder()
                .id("1")
                .fullName("test")
                .age(22)
                .email("test@test.com")
                .country("France")
                .address("nice")
                .password("test")
                .build();

        UserDto userDtoMock = UserDto.builder()
                .fullName("test")
                .age(22)
                .email("test@test.com")
                .country("France")
                .address("nice")
                .password("test")
                .build();

        when(userMapper.toDto(userMock)).thenCallRealMethod();
        when(userMapper.toEntity(userDtoMock)).thenCallRealMethod();
        when(userDaoMock.save(any())).thenReturn(userMock);

        UserDto user = userServiceMock.save(userDtoMock);

        Assertions.assertEquals("test", user.getFullName());
        Assertions.assertEquals("test@test.com", user.getEmail());
        Assertions.assertEquals("France", user.getCountry());
        Assertions.assertEquals("nice", user.getAddress());
        Assertions.assertEquals("test", user.getPassword());
        Assertions.assertEquals(22, user.getAge());
    }

    @Test
    void findByIdTest() {
        Optional<User> optionalUserMock = Optional.of(User.builder()
                .id("1")
                .fullName("test")
                .age(22)
                .email("test@test.com")
                .country("France")
                .address("nice")
                .password("test")
                .build());

        String USER_ID_MOCK = "1";

        when(userMapper.toDto(optionalUserMock.get())).thenCallRealMethod();
        when(userDaoMock.findById(USER_ID_MOCK)).thenReturn(optionalUserMock);
        UserDto user = userServiceMock.findById(USER_ID_MOCK);

        Assertions.assertEquals("test", user.getFullName());
        Assertions.assertEquals("test@test.com", user.getEmail());
        Assertions.assertEquals("France", user.getCountry());
        Assertions.assertEquals("nice", user.getAddress());
        Assertions.assertEquals("test", user.getPassword());
        Assertions.assertEquals(22, user.getAge());
    }

    @Test
    void findByIdWhenNotFoundTest() {
        String USER_ID_MOCK = "2";

        when(userDaoMock.findById(USER_ID_MOCK)).thenReturn(Optional.empty());
        UserDto user = userServiceMock.findById(USER_ID_MOCK);

        Assertions.assertNull(user);
    }
}
