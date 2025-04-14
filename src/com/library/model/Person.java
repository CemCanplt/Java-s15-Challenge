package com.library.model;

// Abstract Person sınıfı
public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void whoYouAre();
}











