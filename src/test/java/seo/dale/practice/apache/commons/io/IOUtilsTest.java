package seo.dale.practice.apache.commons.io;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.TeeOutputStream;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class IOUtilsTest {

    @Test
    public void ouputStreamSplit() throws IOException {
        String exampleText = "A string to be streamed";
        InputStream is = IOUtils.toInputStream(exampleText);

        File tempFile = File.createTempFile("example", "txt");
        tempFile.deleteOnExit();

        OutputStream os1 = new FileOutputStream(tempFile);
        OutputStream os2 = new ByteArrayOutputStream();

        OutputStream tee = new TeeOutputStream(os1, os2);
        IOUtils.copy(is, tee);

        InputStream fis = new FileInputStream(tempFile);
        String content1 = IOUtils.toString(fis);
        String content2 = os2.toString();

        assertEquals(exampleText, content1);
        assertEquals(exampleText, content2);
    }

    @Test
    public void toInputStreamAndToString() throws IOException {
        String exampleText = "An example String";
        InputStream is = IOUtils.toInputStream(exampleText);
        String consumedString = IOUtils.toString(is);

        assertEquals(-1, is.read());
        assertEquals(exampleText, consumedString);
        assertNotSame(exampleText, consumedString);
    }

    @Test
    public void copy() throws IOException {
        String exampleText = "Text to be streamed";
        InputStream is = new ByteArrayInputStream(exampleText.getBytes());
        OutputStream os = new ByteArrayOutputStream();

        IOUtils.copy(is, os);

        String streamContents = os.toString();
        assertEquals(exampleText, streamContents);
        assertNotSame(exampleText, streamContents);
    }

}
