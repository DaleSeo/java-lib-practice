package seo.dale.practice.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonNodeUpdateTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testGetters() throws IOException {
        String jsonAsString = "{\n" +
                "  \"id\"   : 1,\n" +
                "  \"name\" : {\n" +
                "    \"first\" : \"Dale\",\n" +
                "    \"last\" : \"Seo\"\n" +
                "  },\n" +
                "  \"contact\" : [\n" +
                "    { \"type\" : \"phone/home\", \"ref\" : \"111-111-1234\"},\n" +
                "    { \"type\" : \"phone/work\", \"ref\" : \"222-222-2222\"}\n" +
                "  ]\n" +
                "}";
        JsonNode rootNode = mapper.readTree(jsonAsString);

        String resultOriginal = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        System.out.println("#Before Update: " + resultOriginal);

        // Update id
        ((ObjectNode) rootNode).put("id", 1000L);

        // Update name
        JsonNode nameNode = rootNode.path("name");
        ((ObjectNode) nameNode).put("middle", "Daeyoung");

        // Remove first
        ((ObjectNode) nameNode).remove("first");

        // Add contact
        ObjectNode email = mapper.createObjectNode();
        email.put("type", "email");
        email.put("ref", "abc@mkyong.com");

        JsonNode contactNode = rootNode.path("contact");
        ((ArrayNode) contactNode).add(email);

        String resultUpdate = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        System.out.println("#After Update " + resultUpdate);

        assertThat(rootNode.findPath("middle").asText()).isEqualTo("Daeyoung");
        assertThat(rootNode.findPath("first").isMissingNode()).isTrue();
        assertThat(rootNode.path("contact").size()).isEqualTo(3);
    }

}
