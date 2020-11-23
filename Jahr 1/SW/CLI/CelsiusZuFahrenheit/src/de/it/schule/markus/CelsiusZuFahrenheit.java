/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.it.schule.markus;

import java.util.Scanner;

/**
 *
 * @author markus
 */
public class CelsiusZuFahrenheit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        System.out.println("Programm zum Umrechnen von Celsius in Fahrenheit.\n\r");
        System.out.print("Eingabe Celsius °C: ");
        String inputC = s.next();

        try {
            int fahrenheit = (Integer.parseInt(inputC) * 9 / 5) + 32;
            System.out.println("\n\r" + inputC + "°C Entsprechen Fahrenheit " + fahrenheit + " °F");
        } catch (NumberFormatException e) {
            System.out.println("Es können nur Zahlenwerte verarbeitet werden.");
        }
    }

}
