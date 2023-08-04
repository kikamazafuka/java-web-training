package by.training.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactDto {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private long userId;
}
