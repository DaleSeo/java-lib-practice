package seo.dale.practice.apache.commons.lang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class StringUtilsTest {

	@Test
	public void startsWith() {
		assertTrue(StringUtils.startsWith("127.0.0.1", "127"));
		assertFalse(StringUtils.startsWith("123.0.0.1", "127"));
	}

	@Test
	public void endsWith() {
		assertTrue(StringUtils.endsWith("127.0.0.*", "*"));
		assertFalse(StringUtils.endsWith("127.0.0.1", "*"));
	}

	@Test
	public void join() {
		assertEquals("a:b:c", StringUtils.join(new String[]{"a", "b", "c"}, ":"));
		assertEquals("abc", StringUtils.join("a", "b", "c"));
	}

	@Test
	public void testSplit() {
		String str = "I'm very tired.   I'll go to bed.";
		String[] tokens = StringUtils.split(str); // default separator = whitespace
		System.out.println(Arrays.toString(tokens));
		assertEquals(7, tokens.length);

		String[] tokens2 = StringUtils.split(str, " ");
		System.out.println(Arrays.toString(tokens2));
		assertEquals(7, tokens2.length);

		String[] tokens3 = StringUtils.split(str, " .'"); // each whitespace, dot, apostrophe is treated as a separator and a union separator
		System.out.println(Arrays.toString(tokens3));
		assertEquals(9, tokens3.length);

		String[] tokens4 = StringUtils.split(str, "\\s+"); // Regex is not supported
		System.out.println(Arrays.toString(tokens3));
		assertEquals(1, tokens4.length);
	}

	@Test
	public void testSplitGivenMax() {
		String str = "ABC;DEF;___";
		String[] tokens = StringUtils.split(str, ";");
		System.out.println(Arrays.toString(tokens));
		assertArrayEquals(new String[]{"ABC", "DEF", "___"}, tokens);

		String[] tokens1 = StringUtils.split(str, ";", 1);
		System.out.println(Arrays.toString(tokens1));
		assertArrayEquals(new String[]{"ABC;DEF;___"}, tokens1);

		String[] tokens2 = StringUtils.split(str, ";", 2);
		System.out.println(Arrays.toString(tokens2));
		assertArrayEquals(new String[]{"ABC", "DEF;___"}, tokens2);

		String[] tokens3 = StringUtils.split(str, ";", 3);
		System.out.println(Arrays.toString(tokens3));
		assertArrayEquals(new String[]{"ABC", "DEF", "___"}, tokens3);

		String[] tokens4 = StringUtils.split(str, ";", 4);
		System.out.println(Arrays.toString(tokens4));
		assertArrayEquals(new String[]{"ABC", "DEF", "___"}, tokens4);
	}

	@Test
	public void testRemove() {
		String str = "name:Dale Seo";
		String removed = StringUtils.remove(str, "name:");
		assertEquals(removed, "Dale Seo");
	}

}
