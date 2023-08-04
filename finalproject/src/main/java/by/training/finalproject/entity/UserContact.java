package by.training.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserContact {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private long userId;
}
