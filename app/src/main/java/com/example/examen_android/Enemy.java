package com.example.examen_android;

public class Enemy {

    private String name;
    private String age;
    private String description;

    public Enemy(String name, String age, String description) {
        this.name = name;
        this.age = age;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
