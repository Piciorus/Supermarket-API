package application.Domain.Models.User.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class UserResponseGetById {
    private @Getter @Setter String name;
    private @Getter @Setter String surname;
}
