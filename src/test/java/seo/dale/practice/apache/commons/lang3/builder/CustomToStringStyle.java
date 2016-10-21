package seo.dale.practice.apache.commons.lang3.builder;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author 서대영/Store기술개발팀/SKP
 */
public class CustomToStringStyle extends ToStringStyle {

	public static final ToStringStyle CUSTOM_STYLE = new CustomToStringStyle();

	private CustomToStringStyle() {
		super();

		this.setUseClassName(false);
		this.setUseIdentityHashCode(false);

		this.setContentStart(StringUtils.EMPTY);
		this.setContentEnd(StringUtils.EMPTY);

		// this.setArrayStart("[");
		// this.setArrayEnd("]");

		this.setFieldSeparator(",");
		this.setFieldNameValueSeparator("=");

		// this.setNullText("null");

		// this.setSummaryObjectStartText("\"<");
		// this.setSummaryObjectEndText(">\"");

		// this.setSizeStartText("\"<size=");
		// this.setSizeEndText(">\"");
	}

	/**
	 * <p>Ensure <code>Singleton</code> after serialization.</p>
	 *
	 * @return the singleton
	 */
	private Object readResolve() {
		return CUSTOM_STYLE;
	}

	@Override
	public void append(final StringBuffer buffer, final String fieldName, final Object value, final Boolean fullDetail) {
		if (value == null) {
			return;
		}

		appendFieldStart(buffer, fieldName);
		buffer.append("\"" + value + "\"");
		appendFieldEnd(buffer, fieldName);
	}

}
