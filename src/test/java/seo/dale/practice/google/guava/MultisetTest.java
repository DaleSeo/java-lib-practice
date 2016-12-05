package seo.dale.practice.google.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MultisetTest {

    @Test
    public void multitest() {
        Multiset<String> stringMultiset = HashMultiset.create();

        stringMultiset.add("one");
        stringMultiset.add("two");
        stringMultiset.add("two");
        stringMultiset.add("three");
        stringMultiset.add("three");
        stringMultiset.add("three");

        Assert.assertEquals(6, stringMultiset.size());
        Assert.assertEquals(2, stringMultiset.count("two"));

        Set<String> stringSet = stringMultiset.elementSet();

        assertEquals(3, stringSet.size());
    }

}
