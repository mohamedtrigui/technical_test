package peppermint.usermanagementapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String fullName;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    @NotNull
    @Min(value = 18, message = "Only adults living in France can register.")
    private Integer age;

    @NotEmpty
    @Pattern(regexp = "france", flags = {Pattern.Flag.CASE_INSENSITIVE}, message = "Only adults living in France can register.")
    private String country;

    private String address;
}
