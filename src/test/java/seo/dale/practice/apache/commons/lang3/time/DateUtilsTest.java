package seo.dale.practice.apache.commons.lang3.time;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

public class DateUtilsTest {

	@Test
	public void test() throws ParseException {
		Date date = DateUtils.parseDate("2014.09.13 16:47:57", "yyyy.MM.dd HH:mm:ss");
		System.out.println(date);
	}

}
