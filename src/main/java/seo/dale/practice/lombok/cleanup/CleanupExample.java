package seo.dale.practice.lombok.cleanup;

import lombok.Cleanup;

import java.io.*;

public class CleanupExample {

    public static void main(String[] args) throws IOException {
        @Cleanup InputStream in = new ByteArrayInputStream("TEST".getBytes());
        int b;
        while((b = in.read()) != -1) {
            System.out.println((char) b);
        }
    }

}
