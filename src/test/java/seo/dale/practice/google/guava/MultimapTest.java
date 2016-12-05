package seo.dale.practice.google.guava;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MultimapTest {

    @Test
    public void multimap() {
        Multimap<String, String> multimap = HashMultimap.create();

        multimap.put("17 High Street", "Alice Smith");
        multimap.put("17 High Street", "Bob Smith");
        multimap.put("3 Hill Lane", "Simon Anderson");

        Collection<String> smiths = multimap.get("17 High Street");
        assertEquals(2, smiths.size());
        assertTrue(smiths.contains("Alice Smith"));
        assertTrue(smiths.contains("Bob Smith"));

        Assert.assertEquals(1, multimap.get("3 Hill Lane").size());
    }

}
