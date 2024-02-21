package peppermint.usermanagementapp.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import peppermint.usermanagementapp.controllers.UserController;
import peppermint.usermanagementapp.dto.UserDto;
import peppermint.usermanagementapp.services.impl.UserService;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @InjectMocks
    private UserController userControllerMock;

    @Mock
    private UserService userServiceMock;

    @Test
    void createNewUserTest() {
        UserDto userMock = UserDto.builder()
                .fullName("test")
                .age(22)
                .email("test@test.com")
                .country("France")
                .address("nice")
                .password("test")
                .build();

        when(userServiceMock.save(userMock)).thenReturn(userMock);
        ResponseEntity<UserDto> response = userControllerMock.createNewUser(userMock);

        Assertions.assertEquals(userMock, response.getBody());
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void findByIdTest() {
        UserDto userMock = UserDto.builder()
                .fullName("test")
                .age(22)
                .email("test@test.com")
                .country("France")
                .address("nice")
                .password("test")
                .build();
        String USER_ID_MOCK = "1";
        String LANGUAGE_MOCK = "US";

        when(userServiceMock.findById(USER_ID_MOCK)).thenReturn(userMock);
        ResponseEntity<UserDto> response = userControllerMock.findById(USER_ID_MOCK, LANGUAGE_MOCK);

        Assertions.assertEquals(userMock, response.getBody());
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void findByIdWhenUserNotFoundTest() {
        String USER_ID_MOCK = "2";
        String LANGUAGE_MOCK = "US";

        when(userServiceMock.findById(USER_ID_MOCK)).thenReturn(null);
        ResponseEntity<UserDto> response = userControllerMock.findById(USER_ID_MOCK, LANGUAGE_MOCK);

        Assertions.assertEquals(204, response.getStatusCode().value());
    }
}
