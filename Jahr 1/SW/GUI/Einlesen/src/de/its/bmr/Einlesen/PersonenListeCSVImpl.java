package de.its.bmr.Einlesen;


import de.its.bmr.Einlesen.PersonenListe;
import de.its.bmr.Einlesen.Person;
import de.its.bmr.Einlesen.CSV;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Markus
 */
public class PersonenListeCSVImpl implements PersonenListe {

    private ArrayList<Person> personen = new ArrayList<Person>();
    private String filePath;

    public PersonenListeCSVImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void addPerson(Person person) {
        personen.add(person);
    }

    @Override
    public ArrayList<Person> getPersonen() {
        return personen;
    }

    public Person[] getArray(){
        return (Person[]) personen.toArray();
    }
    
    @Override
    public void loadData() {
        BufferedReader bf = null;
        try {
            FileInputStream fs = new FileInputStream(filePath);
            InputStreamReader io = new InputStreamReader(fs);
            bf = new BufferedReader(io);
            String line;

            while ((line = bf.readLine()) != null) {
                Person p = CSV.parse(line);
                if(p != null)
                    personen.add(p);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonenListeCSVImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            Logger.getLogger(PersonenListeCSVImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void saveData(ArrayList<Person> personen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
