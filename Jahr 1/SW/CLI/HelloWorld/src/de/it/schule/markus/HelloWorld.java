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
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Rechner (Nur +!!)");
        Scanner s = new Scanner(System.in);

        System.out.println("Zahl 1 Eingeben:");
        String input1 = s.next();

        System.out.println("Zahl 2 Eingeben:");
        String input2 = s.next();

        try {
            System.out.println("Ergebnis: " + (Integer.parseInt(input1) + Integer.parseInt(input2)));
        } catch (NumberFormatException e) {
            System.out.println("Mach nicht diesen!!");
        }
    }
}