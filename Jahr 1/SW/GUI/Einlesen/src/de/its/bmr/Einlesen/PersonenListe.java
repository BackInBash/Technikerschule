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
    /**
     * Add Person to PersonList
     * @param person 
     */
    public void add(Person person);
    
    /**
     * Remove Person from PersonList
     * @param person 
     */
    public void remove(Person person);
    
    /**
     * Update Person in PersonList
     * @param person 
     */
    public void update(Person person);
    
    /**
     * Load Data from Source
     */
    public void loadData();
    
    /**
     * Get PersonList as ArrayList
     * @return 
     */
    public ArrayList<Person> getPersonen();
    
    /**
     * Get PersonList as Array
     * @return 
     */
    public Person[] getArray();
    
    /**
     * Save Data to Destination
     * @param personen 
     */
    public void saveData(ArrayList<Person> personen);
}
