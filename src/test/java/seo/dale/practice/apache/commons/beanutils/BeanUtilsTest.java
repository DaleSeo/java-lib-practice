package seo.dale.practice.apache.commons.beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author 서대영/Store기술개발팀/SKP
 */
public class BeanUtilsTest {

	@Test
	public void testPopulate() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("no", 1L);
		map.put("name", "Dale Seo");
		map.put("date", new Date());
		map.put("list", Arrays.asList(2, 4, 6, 8));

		Bean bean = new Bean();
		BeanUtils.populate(bean, map);

		System.out.println(bean);

		assertEquals(1L, bean.getNo());
		assertEquals("Dale Seo", bean.getName());
		assertEquals(Arrays.asList(2, 4, 6, 8), bean.getList());
	}

	@Test
	public void testDescribe() throws Exception {
		Bean bean = new Bean(1L, "Dale Seo");
		bean.setList(Arrays.asList(2, 4, 6, 8));
		Map<String, String> map = BeanUtils.describe(bean);
		System.out.println(map);
		assertEquals("1", map.get("no"));
		assertEquals("Dale Seo", map.get("name"));
		assertEquals("2", map.get("list"));
	}

}
