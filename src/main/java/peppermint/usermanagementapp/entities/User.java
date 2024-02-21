package peppermint.usermanagementapp.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;

    private String fullName;

    private String email;

    private String password;

    private Integer age;

    private String country;

    private String address;

}
