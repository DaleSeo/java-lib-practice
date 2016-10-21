package seo.dale.practice.apache.commons.lang3.builder;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

public class ToStringBuilderTest {

	@Test
	public void testOverriddenToString() {
		Person person = new Person(1, "Dale");
		person.setDescription("abcde");
		System.out.println(person.toString());
	}

	@Test
	public void testReflectionToString() {
		Person person = new Person(1, "Dale");
		System.out.println("- default : " + ToStringBuilder.reflectionToString(person));
		// System.out.println(ReflectionToStringBuilder.toString(dummy));
		System.out.println("- simple : " + ToStringBuilder.reflectionToString(person, ToStringStyle.SIMPLE_STYLE));
		System.out.println("- short prefix : : " + ToStringBuilder.reflectionToString(person, ToStringStyle.SHORT_PREFIX_STYLE));
		System.out.println("- multi line : " + ToStringBuilder.reflectionToString(person, ToStringStyle.MULTI_LINE_STYLE));
		System.out.println("- no filed name : " + ToStringBuilder.reflectionToString(person, ToStringStyle.NO_FIELD_NAMES_STYLE));
		System.out.println("- no class name : " + ToStringBuilder.reflectionToString(person, ToStringStyle.NO_CLASS_NAME_STYLE));
		System.out.println("- json : " + ToStringBuilder.reflectionToString(person, ToStringStyle.JSON_STYLE));
	}

}
