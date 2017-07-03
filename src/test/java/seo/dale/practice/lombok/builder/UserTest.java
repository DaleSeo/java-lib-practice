package seo.dale.practice.lombok.builder;

import org.junit.Test;

public class UserTest {

    @Test
    public void test() {
        User user = User.builder()
                .id(1L)
                .username("dale")
                .password("1234")
                .score(70)
                .score(80)
                .build();

        System.out.println(user);
    }
}