package seo.dale.practice.jackson.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Data
public abstract class Domain implements Serializable {

	private static final AtomicLong idGen = new AtomicLong();

	Long id;

	Date createdDate;

	public Domain() {
		this.id = idGen.incrementAndGet();
		this.createdDate = new Date();
	}

}
