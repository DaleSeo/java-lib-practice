package seo.dale.practice.lombok.SneakyThrows;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {

    @SneakyThrows(IOException.class)
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("ABC".getBytes())));
        for (String line; (line = reader.readLine()) != null; ) {
            System.out.println(line);
        }
    }

}
