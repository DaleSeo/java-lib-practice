package seo.dale.practice.apache.commons.lang3.builder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EqualsBuilderTest {

	private Person person0;
	private Person person1;

	@Before
	public void setUp() {
		person0 = new Person(1, "Dale");
		person1 = new Person(1, "Daeyoung");
	}

	@Test
	public void testReflectionEquals() {
		assertTrue(EqualsBuilder.reflectionEquals(new Person(1, "Dale"), new Person(1, "Dale")));
		assertFalse(EqualsBuilder.reflectionEquals(person0, person1));
		assertTrue(EqualsBuilder.reflectionEquals(person0, person1, "name"));
	}



}
