package seo.dale.practice.google.guava;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ImmutableSetTest {

    @Test
    public void immutableSet() {
        Set<Integer> numberSet = new HashSet<>();
        numberSet.add(10);
        numberSet.add(20);
        numberSet.add(30);

        Set<Integer> immutableSet = ImmutableSet.copyOf(numberSet);

        numberSet.remove(10);

        assertTrue(immutableSet.contains(10));

        try {
            immutableSet.remove(10);
            fail();
        } catch (UnsupportedOperationException e) {
            return;
        }

    }

}
