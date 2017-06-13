package seo.dale.practice.jackson.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Map;

@Data
public class Response {

	private int statusCode;

	private String statusMessage;

	private Map<String, String> headers;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String body;

}
