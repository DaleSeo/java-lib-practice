package seo.dale.practice.apache.commons.lang3.builder;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Person {

	private int id;

	private String name;

	private String description;

	public Person() {
	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", "\"" + id + "\"")
				.append("name", StringUtils.join("\"", name, "\""))
				.append("desc", "-- secret --").toString();
	}
}
