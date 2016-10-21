package seo.dale.practice.apache.commons.beanutils;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author 서대영/Store기술개발팀/SKP
 */
public class PropertyUtilsTest {

	@Test
	public void testDescribe() throws Exception {
		Bean bean = new Bean(1L, "Dale Seo");
		bean.setList(Arrays.asList(2, 4, 6, 8));
		Map<String, Object> map = PropertyUtils.describe(bean);
		System.out.println(map);
		assertEquals(1L, map.get("no"));
		assertEquals("Dale Seo", map.get("name"));
		assertEquals(Arrays.asList(2, 4, 6, 8), map.get("list"));
	}

}
