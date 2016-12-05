package seo.dale.practice.apache.http;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class URLEncodedUtilsTest {

	/**
	 * Separator = &
	 */
	@Test
	public void testParseQuery() throws Exception {
		String formUrlEncoded = "category=app+game%2Bmusic&productId=P12345&key=val&key=%EA%B0%92";
		System.out.println("formUrlEncoded : " + formUrlEncoded);

		List<NameValuePair> paramList = URLEncodedUtils.parse(formUrlEncoded, StandardCharsets.UTF_8);
		System.out.println("paramList : " +  paramList);

		assertEquals(4, paramList.size());

		NameValuePair category = paramList.get(0);

		Assert.assertEquals("category", category.getName());
		Assert.assertEquals("app game+music", category.getValue());
	}

	/**
	 * Separator = ;, Double quotes surrounded by strings are ignored
	 */
	@Test
	public void testParseHeader() throws Exception {
		String headerValue = "userkey=\"IM142100000426426201212230725\";devicekey=\"DE20140401045216110\";age=43";
		List<NameValuePair> nameValuePairs = URLEncodedUtils.parse(headerValue, StandardCharsets.UTF_8, ';');
		System.out.println("nameValuePairs : " +  nameValuePairs);

		assertEquals(3, nameValuePairs.size());

		NameValuePair userKey = nameValuePairs.get(0);

		Assert.assertEquals("userkey", userKey.getName());
		Assert.assertEquals("IM142100000426426201212230725", userKey.getValue());
	}

	@Test
	public void testFormat() throws Exception {
		List<NameValuePair> paramList = new ArrayList<>();
		paramList.add(new BasicNameValuePair("category", "app game+music"));
		paramList.add(new BasicNameValuePair("productId", "P12345"));
		paramList.add(new BasicNameValuePair("key", "val"));
		paramList.add(new BasicNameValuePair("key", "값"));
		String formUrlEncoded = URLEncodedUtils.format(paramList, StandardCharsets.UTF_8);
		System.out.println("formUrlEncoded : " + formUrlEncoded);
		assertEquals("category=app+game%2Bmusic&productId=P12345&key=val&key=%EA%B0%92", formUrlEncoded);
	}

}
