package seo.dale.practice.lombok.builder;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
public class User {

    private Long id;
    private String username;
    private String password;
    @Singular
    private List<Integer> scores;

}
