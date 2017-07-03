package seo.dale.practice.lombok.EqualsAndHashCode;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Setter
public class User extends Domain {

    private String username;
    private String password;

}
