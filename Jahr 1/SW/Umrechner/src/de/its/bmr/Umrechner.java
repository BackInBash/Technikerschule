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
public class Umrechner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);

        System.out.println("Bitte geben Sie an, ob Sie von metrischen in englisch Maßeinheiten oder umgekehrt umrechnen wollen.\n (m)etrisch in englisch\n (e)nglisch in metrisch");

        System.out.println("Eingabe: ");
        String auswahlString = s.next();
        char auswahl = auswahlString.toCharArray()[0];

        System.out.print("Bitte geben Sie den Startmeter an: ");
        double startValue = s.nextDouble();

        System.out.print("Bitte geben Sie die Endmeter an: ");
        double endValue = s.nextDouble();

        System.out.println("Meter:      inch:       feet:       yard:");
        for (double i = startValue; endValue >= i; i++) {
            System.out.println(i + ":     " + String.format("%1$,.2f", i * 39.37) + ":        " + String.format("%1$,.2f", i * 3.281) + ":        " + String.format("%1$,.2f", i * 1.09) + ":");
        }
    }
}
