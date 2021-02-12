package de.its.fti1;

import java.util.ArrayList;

/**
 *
 * @author FTI1
 */
public class Person {

    private final int personID;
    private String name;
    private String vorname;
    private final ArrayList<Konto> konten; // <Konto> führt einen Typecast durch, d.h. alle gespeicherten Objekte werden auf den Typ Konto hin überprüft

    public Person(int personID, String name, String vorname) {
        this.personID = personID;
        this.name = name;
        this.vorname = vorname;
        konten = new ArrayList<>();
    }

    public void addKonto(Konto konto) {
        konten.add(konto);
    }

    public Konto[] getKonten() {
        // legt ein leeres Array an
        Konto[] kontenArray = new Konto[this.konten.size()];
        // füllt das Array mit den Referenzen aus der ArrayList
        return konten.toArray(kontenArray);
    }

    public int getPersonID() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    
    public String toString(){
        return this.getPersonID() +": "+ this.getName() +", "+ this.getVorname();
    }
}
