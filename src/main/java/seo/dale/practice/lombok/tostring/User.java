package seo.dale.practice.lombok.tostring;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude = "password")
@Getter @Setter
public class User {

    private Long id;
    private String username;
    private String password;
    private int[] scores;

}
