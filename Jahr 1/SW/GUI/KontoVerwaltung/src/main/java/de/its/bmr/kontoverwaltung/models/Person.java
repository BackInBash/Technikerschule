/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.bmr.kontoverwaltung.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author markus
 */
public class Person {

    private int personID;
    private String name;
    private String vorname;
    private List<Konto> konten;

    public Person() {
        konten = new ArrayList<Konto>();
    }

    public int getPersonID() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public List<Konto> getKonten() {
        return konten;
    }

}
