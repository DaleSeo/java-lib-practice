package seo.dale.practice.jackson;

/**
 * Created by Dale on 2016-01-05.
 */
public class Simple {
    public int x = 1;
    public int y = 2;

    @Override
    public String toString() {
        return String.format("x : %s, y : %s", x, y);
    }
}