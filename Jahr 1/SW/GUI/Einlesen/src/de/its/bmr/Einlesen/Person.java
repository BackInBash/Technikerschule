package de.its.bmr.Einlesen;


import com.google.gson.annotations.SerializedName;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Markus
 */
public class Person {

    @SerializedName(value = "first_name")
    private String firstName;
    @SerializedName(value = "last_name")
    private String lastName;
    private int number;
    private String street;
    @SerializedName(value = "birthdate")
    private Date birthDate;
    @SerializedName(value = "postalcode")
    private int postalCode;
    private String city;
    @SerializedName(value = "phone")
    private String phoneNr;

    public Person(String firstName, String lastName, int number, String street, Date birthDate, int postalCode, String ciry, String phoneNr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.street = street;
        this.birthDate = birthDate;
        this.postalCode = postalCode;
        this.city = ciry;
        this.phoneNr = phoneNr;
    }

    public String getStreet() {
        return street;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumber() {
        return number;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCiry() {
        return city;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void setCiry(String city) {
        this.city = city;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
    public String toString(){
        return firstName+" "+lastName;
    }
}
