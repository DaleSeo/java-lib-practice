package seo.dale.practice.lombok.nonnull;

import org.junit.Test;

import static org.junit.Assert.fail;

public class NonNullExampleTest {

    @Test(expected = NullPointerException.class)
    public void test() {
        NonNullExample nonNullExample = new NonNullExample(null);
        fail();
    }
}