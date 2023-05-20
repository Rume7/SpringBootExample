package io.turntabl.client.models;

import lombok.*;

import java.util.Date;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Client {


    private String firstName;
    private String lastName;
    private String email;

    private char[] password;
    private Date dateRegistered;


    public Client(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password.toCharArray();
        this.dateRegistered = new Date();
    }
}
