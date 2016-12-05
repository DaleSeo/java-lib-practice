package seo.dale.practice.google.guava;

import com.google.common.collect.Iterables;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class IterablesTest {

    @Test
    public void iterables() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = Arrays.asList(5, 6, 7, 8, 9);

        Iterable<Integer> iterable = Iterables.concat(list1, list2, list3, list4);

        Iterator<Integer> iterator = iterable.iterator();

        IntStream.range(0, 10)
                .forEach(i -> assertEquals(Integer.valueOf(i), iterator.next()));

        assertFalse(iterator.hasNext());
    }

}
