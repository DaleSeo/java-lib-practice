package seo.dale.practice.jackson.json;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.List;

/**
 * @author 서대영/Store기술개발팀/SKP
 */
public class Bean {

	private long no;

	private String name;

	private Date createdDate;

	private List<Integer> list;

	public Bean() {
	}

	public Bean(long no, String name) {
		this.no = no;
		this.name = name;
		this.createdDate = new Date();
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}