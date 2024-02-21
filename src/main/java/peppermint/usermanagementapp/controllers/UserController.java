package peppermint.usermanagementapp.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peppermint.usermanagementapp.dto.UserDto;
import peppermint.usermanagementapp.services.impl.UserService;

import java.util.Objects;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    /**
     * This method is a REST endpoint to register the user.
     *
     * @param user
     * @return response with the user created
     */
    @PostMapping("/register")
    public ResponseEntity<UserDto> createNewUser(@Valid @RequestBody UserDto user) {
        UserDto regitredUser = userService.save(user);
        return ResponseEntity.ok(regitredUser);
    }

    /**
     * This method is a REST endpoint to get the user details.
     *
     * @param id of the user
     * @return response with the user or a response with NOT FOUND status
     */
    @GetMapping("{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id, @RequestParam(defaultValue = "US") String language) {
        UserDto user = userService.findById(id);
        if (Objects.nonNull(user)) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.noContent().build();
    }
}
