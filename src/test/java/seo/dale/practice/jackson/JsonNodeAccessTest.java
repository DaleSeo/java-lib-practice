package seo.dale.practice.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonNodeAccessTest {

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
        System.out.println(rootNode);

        // Get id
        JsonNode idNode = rootNode.path("id");
        assertThat(idNode.isNumber()).isTrue();
        long id = idNode.asLong();
        System.out.println("#id: " + id);
        assertThat(id).isEqualTo(1L);

        // Get Name
        JsonNode nameNode = rootNode.path("name");
        assertThat(nameNode.isMissingNode()).isFalse();
        assertThat(nameNode.isObject()).isTrue();

        String firstName = nameNode.path("first").asText();
        String middleName = nameNode.path("middle").asText();
        String lastName = nameNode.path("last").asText();

        System.out.println("#firstName: " + firstName);
        System.out.println("#middleName: " + middleName);
        System.out.println("#lastName: " + lastName);

        assertThat(firstName).isEqualTo("Dale");
        assertThat(middleName).isNullOrEmpty();
        assertThat(lastName).isEqualTo("Seo");

        // Gen Contact
        JsonNode contactNode = rootNode.path("contact");
        assertThat(contactNode.isArray()).isTrue();

        for (JsonNode node : contactNode) {
            String type = node.path("type").asText();
            String ref = node.path("ref").asText();
            System.out.println("#type: " + type);
            System.out.println("#ref: " + ref);
        }
    }

}
