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
public class KFZ_Versicherung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        double Zuschlag = 0;

        System.out.println("Eingabe Alter:");
        int alter = s.nextInt();

        System.out.println("Eingabe Kilometerstand");
        int kilometerstand = s.nextInt();

        System.out.println("Garagenfahrzeug? J/N");
        String garagenfahrzeug = s.next();

        System.out.println("Eingabe Grundbetrag");
        double grundbetrag = s.nextDouble();

        if (alter <= 25) {
            // Grundbetrag + 40%
            Zuschlag = Zuschlag + grundbetrag * 0.4;
        } else {
            // Grundbetrag + 10%
            Zuschlag = Zuschlag - grundbetrag * 0.1;
        }

        if (kilometerstand > 15000) {
            // Grundbetrag + 20%
            Zuschlag = Zuschlag + grundbetrag * 0.20;
        } else {
            // Grundbetrag - 10%
            Zuschlag = Zuschlag - grundbetrag * 0.1;
        }

        if (garagenfahrzeug.toCharArray()[0] == 'n') {
            // Grundbetrag + 5%
            Zuschlag = Zuschlag + grundbetrag * 0.05;
        } else {
            // Grundbetrag - 5%
            Zuschlag = Zuschlag - grundbetrag * 0.05;
        }

        System.out.println("Grundbetrag " + grundbetrag + " Zuschlag: " + Zuschlag);
    }

}
