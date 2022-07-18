package com.buggy.car.portals.beans;

public class LoginBean {

    //Encapsulation is to make sure that "sensitive" data is hidden from users.
    //To achieve this, you must:
    //declare class variables/attributes as private
    //provide public get and set methods to access
    //and update the value of a private variable
    //The get method returns the value of the variable name.
    //The set method takes a parameter (name) and assigns it to the name variable.
    //The 'this' keyword is used to refer to the current object.
    //'name' variable is declared as private, cannot access it from outside this class

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
