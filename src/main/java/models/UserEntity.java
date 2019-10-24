package models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserEntity {
    private int id;
    private String firstName;
    private String email;
    private String lastName;
    private String password;
    private String picName;


    public UserEntity(String firstName, String email, String lastName, String password) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.password = password;
    }
}
