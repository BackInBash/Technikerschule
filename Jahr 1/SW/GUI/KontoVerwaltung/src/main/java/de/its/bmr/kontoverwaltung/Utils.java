/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.bmr.kontoverwaltung;

import de.its.bmr.kontoverwaltung.models.Konto;

/**
 *
 * @author markus
 */
public class Utils {

    public static void transfer(Konto from, Konto to, double amount) {
        // Girokonto darf überall hin Überweisen
        if (from.getClass().getName().equals("Girokonto")) {
            if (to.getClass().getName().equals("Festgeldkonto")) {
                if(amount >= 5000)
                    from.ueberweisen(amount, to);
            } else {
                from.ueberweisen(amount, to);
            }
        }

        // From Sparkonto to Girokonto
        if (from.getClass().getName().equals("Sparkonto")) {
            if (to.getClass().getName().equals("Girokonto")) {
                from.ueberweisen(amount, to);
            }
        }

        // From Festgeldkonto to Girokonto
        if (from.getClass().getName().equals("Festgeldkonto")) {
            if (to.getClass().getName().equals("Girokonto")) {
                from.ueberweisen(amount, to);
            }
        }
    }
}
