package io.turntabl.client.models;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class ClientDTO {

    @Id
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateRegistered;

    public ClientDTO() {
        uuid = UUID.randomUUID();
    }
}
