package seo.dale.practice.lombok.SneakyThrows;

import org.junit.Test;

public class SneakyThrowsExampleTest {

    @Test
    public void test() {
        SneakyThrowsExample ste = new SneakyThrowsExample();
        ste.run();
    }

    @Test
    public void test2() {
        SneakyThrowsExample ste = new SneakyThrowsExample();
        ste.utf8ToString("ABC".getBytes());
    }

}