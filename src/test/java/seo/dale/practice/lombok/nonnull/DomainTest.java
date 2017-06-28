package seo.dale.practice.lombok.nonnull;

import org.junit.Test;

import static org.junit.Assert.*;

public class DomainTest {

    @Test(expected = NullPointerException.class)
    public void test() {
        Domain domain = new Domain();
        domain.setId(null);
        fail();
    }
}