package seo.dale.practice.jackson.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(value = {"host"}, ignoreUnknown = true)
public class Request {

	String method;

	String host;

	String path;

	Map<String, String> queries;

	Map<String, String> headers;

	String body;

}
