package seo.dale.practice.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import seo.dale.practice.jackson.json.Bean;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author 서대영/Store기술개발팀/SKP
 */
public class ObjectMapperTest {

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testConvertValue() throws Exception {
		Bean bean = new Bean(1L, "Dale Seo");
		bean.setList(Arrays.asList(2, 4, 6, 8));

		Map<String, Object> map = mapper.convertValue(bean, Map.class);
		System.out.println(map);

		assertEquals(1L, map.get("no"));
		assertEquals("Dale Seo", map.get("name"));
		assertEquals(Arrays.asList(2, 4, 6, 8), map.get("list"));
	}

	@Test
	public void testConvertValueWithNonEmptyIncluded() throws Exception {
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

		Bean bean = new Bean(0L, "Dale Seo");

		Map<String, Object> map = mapper.convertValue(bean, Map.class);
		System.out.println(map);

		// Default long value (0L) is included by @JsonInclude(JsonInclude.Include.NON_EMPTY)
		// http://fasterxml.github.io/jackson-annotations/javadoc/2.7/com/fasterxml/jackson/annotation/JsonInclude.Include.html#NON_EMPTY
		assertEquals(0L, map.get("no"));
		assertEquals("Dale Seo", map.get("name"));
		// A null list is not included by @JsonInclude(JsonInclude.Include.NON_EMPTY)
		assertNull(map.get("list"));
	}

}
