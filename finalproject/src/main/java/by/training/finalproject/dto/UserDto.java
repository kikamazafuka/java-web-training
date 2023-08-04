package by.training.finalproject.dto;

import by.training.finalproject.dto.ContactDto;
import by.training.finalproject.entity.Role;
import by.training.finalproject.entity.RoleEnum;
import lombok.*;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class UserDto {
    private Long id=1L;
    private String login;
    private String password;
    private Role role;
    private ContactDto contactDto;

    public UserDto(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
