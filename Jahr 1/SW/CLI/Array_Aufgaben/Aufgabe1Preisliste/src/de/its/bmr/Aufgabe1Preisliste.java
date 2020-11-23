/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.bmr;

import java.util.Scanner;

/**
 *
 * @author markus
 */
public class Aufgabe1Preisliste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[] preisliste = new double[5];
        double mittelwert = 0;
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < preisliste.length; i++) {
            System.out.print("Eingabe Preis " + (i + 1) + ": ");
            preisliste[i] = s.nextDouble();
        }

        for (int i = 0; i < preisliste.length; i++) {
            mittelwert = mittelwert + preisliste[i];
            System.out.println("Ausgabe Preis " + (i + 1) + ": " + preisliste[i]);
        }

        System.out.println("Ausgabe Mittelwert: " + mittelwert / preisliste.length);
    }

}
