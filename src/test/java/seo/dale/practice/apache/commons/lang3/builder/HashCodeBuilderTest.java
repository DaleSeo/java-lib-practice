package seo.dale.practice.apache.commons.lang3.builder;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HashCodeBuilderTest {

	private Person person0;
	private Person person1;

	@Before
	public void setUp() {
		person0 = new Person(1, "Dale");
		person1 = new Person(1, "Daeyoung");
	}

	@Test
	public void testReflectionHashCode() {
		int hashCode0 = HashCodeBuilder.reflectionHashCode(person0);
		int hashCode0_1 = HashCodeBuilder.reflectionHashCode(person0);
		assertTrue(hashCode0 == hashCode0_1);

		int hashCode1 = HashCodeBuilder.reflectionHashCode(person1);
		assertTrue(hashCode0 != hashCode1);
	}

	@Test
	public void testReflectionHashCodeExcludingFields() {
		int hashCode0 = HashCodeBuilder.reflectionHashCode(person0, "name");
		int hashCode1 = HashCodeBuilder.reflectionHashCode(person1, "name");

		assertTrue(hashCode0 == hashCode1);
	}

}
