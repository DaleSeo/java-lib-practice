package seo.dale.practice.lombok.EqualsAndHashCode;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void test() {
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("user");
        user1.setPassword("pass");

        User user2 = new User();
        user1.setId(2L);
        user2.setUsername("user");
        user2.setPassword("pass");

        System.out.println(user1.equals(user2));
    }
}