package seo.dale.practice.lombok.constructor;

import org.junit.Test;

public class UserTest {

    @Test
    public void testNoArgsConstructor() {
        User user = new User();
    }

    @Test
    public void testRequiredArgsConstructor() {
        User user = new User("id", "pw");
    }

    @Test
    public void testAllArgsConstructor() {
        User user = new User(1L, "id", "pw", null);
    }

}