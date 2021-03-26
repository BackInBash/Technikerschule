/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.bmr.Einlesen;

/**
 *
 * @author Markus
 */
public class PersonenListeFactory {

    private PersonenListe p = null;

    public PersonenListeFactory(String path) {
        if (path.endsWith(".csv")) {
            p = new PersonenListeCSVImpl(path);
        }
        if (path.endsWith(".json")) {
            p = new PersonenListeJSONImpl(path);
        }
    }

    public PersonenListe create() {
        return p;
    }
}
