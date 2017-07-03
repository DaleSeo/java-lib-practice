package seo.dale.practice.lombok.tostring;

import org.junit.Test;

public class UserTest {

    @Test
    public void test() {
        User user = new User();
        user.setId(1L);
        user.setUsername("dale");
        user.setUsername("1234");
        user.setScores(new int[]{80, 70, 100});
        System.out.println(user);
    }
}