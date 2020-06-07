package com.hrishique.contactsapp;

public class Contacts {
    public Contacts(String id, String contactname, String contactemail, String contactnumber) {
        this.id = id;
        this.contactname = contactname;
        this.contactemail = contactemail;
        this.contactnumber = contactnumber;
    }
    public Contacts() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getContactemail() {
        return contactemail;
    }

    public void setContactemail(String contactemail) {
        this.contactemail = contactemail;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    String id;
    String contactname;
    String contactemail;
    String contactnumber;
}
