package seo.dale.practice.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import seo.dale.practice.jackson.domain.*;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonAnnotationsTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testJsonIgnore() throws JsonProcessingException {
        User user = new User("user", "user@test.com", "1234");

        String userAsString = mapper.writeValueAsString(user);
        System.out.println("#userAsString: " + userAsString);

        assertThat(userAsString).contains("email");
        assertThat(userAsString).doesNotContain("password");
    }

    @Test
    public void testJsonInclude() throws JsonProcessingException {
        Response response = new Response();
        response.setStatusCode(200);
        response.setStatusMessage("OK");

        String responseAsString = mapper.writeValueAsString(response);
        System.out.println("#responseAsString: " + responseAsString);

        assertThat(responseAsString).contains("headers");
        assertThat(responseAsString).doesNotContain("body");
    }

    @Test
    public void testJsonProperty() throws JsonProcessingException {
        User user = new User("user", "user@test.com", "1234");

        String userAsString = mapper.writeValueAsString(user);
        System.out.println("#userAsString: " + userAsString);

        assertThat(userAsString).contains("\"username\":\"user\"");
        assertThat(userAsString).doesNotContain("\"name\":\"user\"");
    }

    @Test
    public void testJsonIgnorePropertiesValue() throws IOException {
        Request request = new Request();
        request.setHost("http://jsonplaceholder.typicode.com"); // @JsonIgnoreProperties(value = {"host"})
        request.setPath("/posts/1");
        request.setMethod("GET");

        String requestAsString = mapper.writeValueAsString(request);
        System.out.println("#requestAsString: " + requestAsString);

        assertThat(requestAsString).contains("path");
        assertThat(requestAsString).doesNotContain("host");
    }

    @Test
    public void testJsonIgnorePropertiesIgnoreUnknown() throws IOException {
        // Unrecognized field "port"
        String requestAsString = "{\"port\":8080,\"method\":\"GET\",\"path\":\"/posts/1\",\"queries\":null,\"headers\":null,\"body\":null}";
        System.out.println(requestAsString);

        // @JsonIgnoreProperties(ignoreUnknown = true)
        Request request = mapper.readValue(requestAsString, Request.class);
        System.out.println("#request: " + request);
        assertThat(request).isNotNull();
    }

    @Test
    public void testJsonIgnoreType() throws JsonProcessingException {
        Request request = new Request();
        request.setHost("http://jsonplaceholder.typicode.com"); // @JsonIgnoreProperties(value = {"host"})
        request.setPath("/posts/1");
        request.setMethod("GET");

        Response response = new Response();
        response.setStatusCode(200);
        response.setStatusMessage("OK");

        Result result = new Result();
        result.setPassed(true);

        Call call = new Call();

        String callAsString = mapper.writeValueAsString(call);
        System.out.println("#call: " + call);

        assertThat(callAsString).contains("request");
        assertThat(callAsString).contains("response");
        assertThat(callAsString).doesNotContain("result");
    }

}
