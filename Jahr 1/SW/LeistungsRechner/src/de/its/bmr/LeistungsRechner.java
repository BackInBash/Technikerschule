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
public class LeistungsRechner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);

        System.out.println("Spannung angeben:");
        double volt = s.nextDouble();

        System.out.println("Strom angeben");
        double ampere = s.nextDouble();

        System.out.println("1.) Wiederstand oder  2.) Leistung Berechnen?");
        int operation = s.nextInt();

        if (operation == 1) {
            System.out.println("Wiederstand ausgeben...");
            System.out.println("Wiederstand " + volt / ampere + " Ohm");
        }
        if (operation == 2) {
            System.out.println("Leistung ausgeben...");
            System.out.println("Leistung " + volt * ampere + " Watt");
        }
    }
}
