package de.its.bmr.Einlesen;


import de.its.bmr.Einlesen.PersonenListe;
import de.its.bmr.Einlesen.Person;
import de.its.bmr.Einlesen.CSV;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
public class PersonenListeJSONImpl implements PersonenListe {

    private ArrayList<Person> personen = new ArrayList<Person>();
    private String filePath;

    public PersonenListeJSONImpl(String filePath) {
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
            StringBuilder data = new StringBuilder();
            
            while ((line = bf.readLine()) != null) {
                data.append(line);
            }
            
            personen.addAll(JSON.parse(data.toString()));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonenListeJSONImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            Logger.getLogger(PersonenListeJSONImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public void saveData(ArrayList<Person> personen){
        BufferedWriter bf = null;
        try {
            FileOutputStream fs = new FileOutputStream(filePath);
            OutputStreamWriter io = new OutputStreamWriter(fs);
            bf = new BufferedWriter(io);

            bf.write(JSON.serialise(personen));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonenListeJSONImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            Logger.getLogger(PersonenListeJSONImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
