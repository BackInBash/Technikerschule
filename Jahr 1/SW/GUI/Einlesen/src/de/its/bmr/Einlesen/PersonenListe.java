package de.its.bmr.Einlesen;


import de.its.bmr.Einlesen.Person;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Markus
 */
public interface PersonenListe {
    public void addPerson(Person person);
    public void loadData();
    public ArrayList<Person> getPersonen();
    public Person[] getArray();
    public void saveData(ArrayList<Person> personen);
}
