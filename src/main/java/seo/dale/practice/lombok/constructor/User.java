package seo.dale.practice.lombok.constructor;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    @NonNull
    private String username;
    @NonNull
    private String password;
    private int[] scores;

}
