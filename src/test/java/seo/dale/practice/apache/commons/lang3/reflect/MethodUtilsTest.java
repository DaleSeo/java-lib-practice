package seo.dale.practice.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.MethodUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

/**
 * @author Dale Seo
 */
public class MethodUtilsTest {

	@Test
	public void testInvokeMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Dummy printer = new Dummy();
		String reversed = (String) MethodUtils.invokeMethod(printer, "reverse", "ABCDE");
		assertEquals("EDCBA", reversed);
	}

	@Test(expected = NoSuchMethodException.class)
	public void testThrowNoSuchMethodException() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Dummy printer = new Dummy();
		MethodUtils.invokeMethod(printer, "print2", "ABCDE");
	}

}

class Dummy {

	public String reverse(String text) {
		return new StringBuilder(text).reverse().toString();
	}

	private void print(String text) {
		System.out.println(text);
	}

}
