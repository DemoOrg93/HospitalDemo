package com.prakriti.finaldemo.Pojo;

/**
 * Created by Prakriti on 09/08/2017.
 */

public class HospitalDescription {
    private String Description;
    private String Contact;
    private String Facilities;


    public HospitalDescription(String description, String contact, String facilities) {
        Description = description;
        Contact = contact;
        Facilities = facilities;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getFacilities() {
        return Facilities;
    }

    public void setFacilities(String facilities) {
        Facilities = facilities;
    }
}
