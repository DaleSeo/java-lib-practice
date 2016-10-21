package seo.dale.practice.apache.commons.lang3;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringEscapedUtilsTest {

    @Test
    public void escapeHtml4() {
        String exampleText = "Left & Right";
        String escapedString = StringEscapeUtils.escapeHtml4(exampleText);
        assertEquals("Left &amp; Right", escapedString);
    }

}
