package de.its.bmr.Einlesen;


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
public class PersonenListeCSVImpl implements PersonenListe {

    private ArrayList<Person> personen = new ArrayList<Person>();
    private String filePath;

    public PersonenListeCSVImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void add(Person person) {
        personen.add(person);
    }
    
    @Override
    public void remove(Person person) {
        personen.remove(person);
    }

    @Override
    public void update(Person person) {
        personen.remove(personen.stream()
                .filter(x -> x.getFirstName().equals(person.getFirstName())
                    && x.getLastName().equals(person.getLastName())
                    && x.getPhoneNr().equals(person.getPhoneNr()))
                .findFirst().get());
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
        BufferedWriter bf = null;
        try {
            FileOutputStream fs = new FileOutputStream(filePath);
            OutputStreamWriter io = new OutputStreamWriter(fs);
            bf = new BufferedWriter(io);
            StringBuilder data = new StringBuilder();

            for (Person person : personen) {
                data.append(CSV.serialise(person));
                
            }
            bf.write(data.toString());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonenListeCSVImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            Logger.getLogger(PersonenListeCSVImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
