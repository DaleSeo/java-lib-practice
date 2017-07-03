package seo.dale.practice.lombok.SneakyThrows;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.*;

public class Listing7 {

    @SneakyThrows({FileNotFoundException.class, IOException.class})
    public static void main(String args[]) {
        @Cleanup
        FileInputStream fis = null;
        @Cleanup
        BufferedReader reader = null;
        fis = new FileInputStream(
                "/path-to-file/upload.log");
        reader = new BufferedReader(
                new InputStreamReader(fis));

        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
    }

}
