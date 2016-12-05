package seo.dale.practice.lombok;

import org.junit.Test;

public class MountainTest {

	@Test
	public void testName() {
		Mountain mountain = new Mountain();
		mountain.setName("Baekdu");
		mountain.setLatitude(10.1);
		mountain.setLongitude(20.2);
		mountain.setCountry("North Korea");
		System.out.println(mountain);
	}

}