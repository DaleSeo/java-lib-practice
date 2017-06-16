package seo.dale.practice.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonNodeTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void test() throws IOException {
        String jsonString = "{\"id\":1,\"createdDate\":1497351968054,\"email\":\"user@test.com\",\"roles\":null,\"username\":\"user\"}";

        JsonNode node = mapper.readTree(jsonString);
        System.out.println("#node: " + node);

        JsonNode idNode = node.get("id");
        assertThat(idNode.longValue()).isEqualTo(1L);

        JsonNode nameNode = node.get("username");
        assertThat(nameNode.textValue()).isEqualTo("user");

        JsonNode createdDateNode = node.get("createdDate");
        System.out.println(createdDateNode); // TODO: figure out how to convert to a Date object
    }

    @Test
    public void name() throws IOException {
        String lineString = "{\"id\":1,\"createdDate\":1497351968054,\"email\":\"user@test.com\",\"roles\":null,\"username\":\"user\"}";
        JsonNode node1 = mapper.readTree(lineString);
        System.out.println("#node1: " + node1);

        String prettyString = "{  \n" +
                "   \"id\":1,\n" +
                "   \"createdDate\":1497351968054,\n" +
                "   \"email\":\"user@test.com\",\n" +
                "   \"roles\":null,\n" +
                "   \"username\":\"user\"\n" +
                "}";
        JsonNode node2 = mapper.readTree(prettyString);
        System.out.println("#node2: " + node2);

        assertThat(node1.equals(node2)).isTrue();
    }
}
