package seo.dale.practice.jackson.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class XmlMapperTest {

    ObjectMapper xmlMapper;

    @Before
    public void setUp() {
        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        xmlMapper = new XmlMapper(module);
    }

    @Test
    public void writeValueAsString() throws JsonProcessingException {
        String xml = xmlMapper.writeValueAsString(new Simple());
        System.out.println(xml);
    }

    @Test
    public void readValue() throws IOException {
        Simple obj = xmlMapper.readValue("<Simple><x>1</x><y>2</y></Simple>", Simple.class);
        System.out.println(obj);
    }



}
