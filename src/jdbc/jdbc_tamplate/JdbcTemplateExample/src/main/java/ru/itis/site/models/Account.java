package ru.itis.site.models;

import lombok.*;

// модель account
@Data // заменяется Getter, Setter,toString, equalsAndHashcode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    private Long id;
    private String firstName;
    private String lastName;
    private Boolean isActive;
}
