package com.example.qlcb;

public class Unit {
    private String name;
    private String phone;
    //private String address;
    private int image;
    public Unit(String name, String phone, int image) {
        this.name = name;
        this.phone = phone;
        //this.address = address;
        this.image = image;
    }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    //public String getAddress() { return address; }
    public int getImage() { return image; }
}
