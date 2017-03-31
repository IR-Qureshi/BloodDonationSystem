package com.example.dellpc.blooddonationsystem;

/**
 * Created by dell pc on 26-Feb-17.
 */

public class ClassPostReq {
    String bloodGroup;
    String noUnits;
    String urgency;
    String country;
    String state;
    String city;
    String hospital;
    String relation;
    String contact;
    String addIns;

    public ClassPostReq(){

    }
    public ClassPostReq(String bloodGroup, String noUnits, String urgency, String country, String state, String city, String hospital, String relation, String contact, String addIns){
        this.bloodGroup = bloodGroup;
        this.noUnits = noUnits;
        this.urgency = urgency;
        this.country = country;
        this.state = state;
        this.city = city;
        this.hospital = hospital;
        this.relation = relation;
        this.contact = contact;
        this.addIns = addIns;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getNoUnits() {
        return noUnits;
    }

    public String getUrgency() {
        return urgency;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getAddIns() {
        return addIns;
    }

    public String getContact() {
        return contact;
    }

    public String getHospital() {
        return hospital;
    }

    public String getRelation() {
        return relation;
    }
}

