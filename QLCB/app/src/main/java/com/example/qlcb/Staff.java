package com.example.qlcb;

public class Staff {
    private String name;
    private String phone;
    private int image;
    private String position;
    private String email;

    public Staff(String name, String phone, int image, String email, String position) {
        this.name = name;
        this.phone = phone;
        this.image = image;
        this.position = position;
        this.email = email;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public int getImage(){return  image;}
    public String getPosition() { return position; }

    public String getEmail() { return email; }
}
