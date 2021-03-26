package de.its.bmr.Einlesen;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class CSV {

    public static Person parse(String line) {
        try {
            String[] splitted = line.split(";");
            DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
            return new Person(splitted[0], splitted[1], Integer.parseInt(splitted[2]), splitted[3], df.parse(splitted[4]), Integer.parseInt(splitted[5]), splitted[6], splitted[7]);
        } catch (ParseException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException e) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
