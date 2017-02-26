package com.example.dellpc.blooddonationsystem;

/**
 * Created by dell pc on 26-Feb-17.
 */

public class ClassUser {
    String firstName;
    String lastName;
    String email;
    String bloodGroup;

    public ClassUser(){

    }
    public ClassUser(String FirstName, String LastName, String Email, String BloodGroup){
        this.firstName = FirstName;
        this.lastName = LastName;
        this.email = Email;
        this.bloodGroup = BloodGroup;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }


}
