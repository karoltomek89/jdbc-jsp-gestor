package model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.Membership;

@Getter
@Setter
@ToString
public class User {
    private int userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Membership membership;

}
