package seo.dale.practice.apache.commons.lang3.time;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

public class DateFormatUtilsTest {

	@Test
	public void test() {
		String dateText = DateFormatUtils.format(new Date(), "yyyy.MM.dd HH:mm:ss");
		System.out.println(dateText);
	}

}
