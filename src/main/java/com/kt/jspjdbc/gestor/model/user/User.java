package com.kt.jspjdbc.gestor.model.user;

import com.kt.jspjdbc.gestor.model.Membership;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
