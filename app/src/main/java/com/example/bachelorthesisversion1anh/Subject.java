package com.example.bachelorthesisversion1anh;

public class Subject {
    private String Name;
    private String Description;
    private int  Img;

    public Subject(String name, String description, int img) {
        Name = name;
        Description = description;
        Img = img;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }
}
