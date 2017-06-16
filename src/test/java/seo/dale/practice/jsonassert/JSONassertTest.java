package seo.dale.practice.jsonassert;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 * http://jsonassert.skyscreamer.org/
 * http://jsonassert.skyscreamer.org/cookbook.html
 */
import static org.junit.Assert.fail;

public class JSONassertTest {

    @Test(expected = AssertionError.class)
    public void test() throws JSONException {
        String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]}],pets:[]}";
        String actual = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
        JSONAssert.assertEquals(expected, actual, false);
        fail();
    }

    @Test
    public void testSimple() throws JSONException {
        String result = "{id:1}";
        JSONAssert.assertEquals("{id:1}", result, false);
    }

    @Test(expected = AssertionError.class)
    public void testMode() throws JSONException {
        String result = "{id:1,name:\"Juergen\"}";
        JSONAssert.assertEquals("{id:1}", result, false); // Pass
        JSONAssert.assertEquals("{id:1}", result, true); // Fail
        fail();
    }

    @Test
    public void testIgnoreFieldOrder() throws JSONException {
        String result = "{id:1,name:\"Juergen\"}";
        JSONAssert.assertEquals("{name:\"Juergen\",id:1}", result, true);
    }

}
