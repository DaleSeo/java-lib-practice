package seo.dale.practice.jackson.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class User extends Domain {

    @JsonProperty("username")
    private String name;

    private String email;

    @JsonIgnore
    private String password;

    private List<String> roles;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

}
