package seo.dale.practice.lombok.nonnull;

import lombok.NonNull;

public class NonNullExample {

    private String name;

    public NonNullExample(@NonNull Person person) {
        this.name = person.getName();
    }

    static class Person {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
