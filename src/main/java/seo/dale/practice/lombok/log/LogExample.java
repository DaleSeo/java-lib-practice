package seo.dale.practice.lombok.log;

import lombok.extern.java.Log;

import java.util.logging.Level;

@Log
public class LogExample {

    public static void main(String... args) {
        log.info("INFO");
        log.log(Level.FINE, "FINE");
    }

}