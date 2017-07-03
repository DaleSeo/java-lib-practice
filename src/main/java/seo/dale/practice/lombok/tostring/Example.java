package seo.dale.practice.lombok.tostring;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude="id")
@Getter @Setter
public class Example {
    private static final int STATIC_VAR = 10;
    private String name;
    private Shape shape = new Square(5, 10);
    private String[] tags;
    private int id;

}
