package seo.dale.practice.lombok.tostring;

import org.junit.Test;

public class ExampleTest {

    @Test
    public void test() {
        Example example = new Example();
        example.setId(1);
        example.setName("Dale");
        example.setTags(new String[]{"A", "B", "C"});
        System.out.println(example);
    }

}