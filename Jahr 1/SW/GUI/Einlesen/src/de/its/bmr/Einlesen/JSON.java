/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.bmr.Einlesen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 *
 * @author Markus
 */
public class JSON {

    public static ArrayList<Person> parse(String data) {
        Gson json = new GsonBuilder()
                .setDateFormat("dd.mm.yyyy").create();
        Person[] p = json.fromJson(data, Person[].class);
        ArrayList<Person> person = new ArrayList<Person>();
        for (Person per : p) {
            person.add(per);
        }
        return person;
    }

    public static String serialise(ArrayList<Person> personen) {
        Gson json = new GsonBuilder()
                .setDateFormat("dd.mm.yyyy").create();
        String p = json.toJson(personen, Person[].class);
        return p;
    }
}
