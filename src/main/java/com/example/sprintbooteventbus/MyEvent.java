package com.example.sprintbooteventbus;

public class MyEvent {
    private final String name;

    public MyEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
