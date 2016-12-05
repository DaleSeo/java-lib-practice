package seo.dale.practice.google.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BiMapTest {

    @Test
    public void biamp() {
        BiMap<String, String> stockToCompany = HashBiMap.create();
        BiMap<String, String> compnayToStock = stockToCompany.inverse();

        stockToCompany.put("GOOG", "Google");
        stockToCompany.put("AAPL", "Apple");

        compnayToStock.put("Facebook", "FB");

        Assert.assertEquals("Google", stockToCompany.get("GOOG"));
        Assert.assertEquals("AAPL", compnayToStock.get("Apple"));
        Assert.assertEquals("Facebook", stockToCompany.get("FB"));

        System.out.println(stockToCompany);
    }
}
