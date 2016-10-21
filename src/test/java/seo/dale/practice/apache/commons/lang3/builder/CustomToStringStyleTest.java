package seo.dale.practice.apache.commons.lang3.builder;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author 서대영/Store기술개발팀/SKP
 */
public class CustomToStringStyleTest {

	@Test
	public void testCustomToStringWithObject() {
		Person person = new Person(1, "Dale");
		String string = ToStringBuilder.reflectionToString(person, CustomToStringStyle.CUSTOM_STYLE);
		System.out.println(string);
		assertEquals("id=\"1\",name=\"Dale\"", string);
	}


	// Map 하다가 포기
	@Ignore
	@Test
	public void testCustomToStringWithMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("no", "1");
		map.put("name", "Dale");
		map.put("description", "");

		String string = ToStringBuilder.reflectionToString(map, CustomToStringStyle.CUSTOM_STYLE);
		System.out.println(string);
		assertEquals("id=\"1\",name=\"Dale\"", string);
	}

}