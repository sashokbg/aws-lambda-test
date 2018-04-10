package fr.ddf.aws.handlers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class HelloMessage {

    private String name;
    private Integer age;

    public HelloMessage(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public HelloMessage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonCreator
    public static HelloMessage create(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();

        HelloMessage helloMessage = null;
        try {
            helloMessage = objectMapper.readValue(jsonString, HelloMessage.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return helloMessage;
    }
}
