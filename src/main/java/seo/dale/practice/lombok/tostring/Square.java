package seo.dale.practice.lombok.tostring;

import lombok.ToString;

@ToString(callSuper=true, includeFieldNames=false)
public class Square extends Shape {
    private final int width, height;

    public Square(int width, int height) {
        this.width = width;
        this.height = height;
    }
}

