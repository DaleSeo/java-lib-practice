package seo.dale.practice.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import seo.dale.practice.jackson.domain.Bean;
import seo.dale.practice.jackson.domain.User;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public class ObjectMapperTest {

	@Test
	public void testConvertValue() throws Exception {
		Bean bean = new Bean(1L, "Dale Seo");
		bean.setList(Arrays.asList(2, 4, 6, 8));

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.convertValue(bean, Map.class);
		System.out.println(map);

		assertEquals(1L, map.get("no"));
		assertEquals("Dale Seo", map.get("name"));
		assertEquals(Arrays.asList(2, 4, 6, 8), map.get("list"));
	}

	@Test
	public void testConvertValueWithNonEmptyIncluded() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
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

	@Test(expected = UnrecognizedPropertyException.class)
	public void throwUnrecognizedPropertyException() throws IOException {
		// Unrecognized field "no"
		String userAsString = "{\"no\":1,\"createdDate\":1497351968054,\"email\":\"user@test.com\",\"roles\":null,\"username\":\"user\"}";

		ObjectMapper mapper = new ObjectMapper();
		mapper.readValue(userAsString, User.class);
		fail();
	}

	@Test
	public void throwIgnoreUnrecognizedFields() throws IOException {
		// Unrecognized field "no"
		String userAsString = "{\"no\":1,\"createdDate\":1497351968054,\"email\":\"user@test.com\",\"roles\":null,\"username\":\"user\"}";

		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		User user = mapper.readValue(userAsString, User.class);
		System.out.println("#user: " + user);
		assertThat(user).isNotNull();
	}

	@Test
	public void testWriterWithDefaultPrettyPrinter() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode = mapper.createObjectNode();
		objectNode.put("no", 1);
		objectNode.put("createdDate", 1497351968054L);
		objectNode.put("email", "user@test.com");
		objectNode.putNull("roles");
		objectNode.put("username", "user");

		String jsonAsString = mapper.writeValueAsString(objectNode);
		System.out.println("#jsonAsString: " + jsonAsString);
		String expectedString = "{\"no\":1,\"createdDate\":1497351968054,\"email\":\"user@test.com\",\"roles\":null,\"username\":\"user\"}";
		assertThat(jsonAsString).isEqualTo(expectedString);

		String jsonAsPrettyString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);
		String expectedPrettyString = "{\n" +
				"  \"no\" : 1,\n" +
				"  \"createdDate\" : 1497351968054,\n" +
				"  \"email\" : \"user@test.com\",\n" +
				"  \"roles\" : null,\n" +
				"  \"username\" : \"user\"\n" +
				"}";
		System.out.println("#jsonAsPrettyString: " + jsonAsPrettyString);
		assertThat(jsonAsPrettyString).isEqualTo(expectedPrettyString);
	}

}