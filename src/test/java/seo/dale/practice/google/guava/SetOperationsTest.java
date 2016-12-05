package seo.dale.practice.google.guava;

import com.google.common.collect.Sets;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class SetOperationsTest {

    @Test
    public void setOperations() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Sets.SetView<Integer> unionView = Sets.union(set1, set2);
        Assert.assertEquals(5, unionView.immutableCopy().size());

        Sets.SetView<Integer> differenceView = Sets.difference(set1, set2);
        Assert.assertEquals(2, differenceView.immutableCopy().size());

        Sets.SetView<Integer> intersectionView = Sets.intersection(set1, set2);
        set2.add(2);
        Set<Integer> intersection = intersectionView.immutableCopy();
        assertTrue(intersection.contains(2));
        assertTrue(intersection.contains(3));
    }
}
