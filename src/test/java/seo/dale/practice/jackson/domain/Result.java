package seo.dale.practice.jackson.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Data;

@Data
@JsonIgnoreType
public class Result {

	private boolean passed;

}
