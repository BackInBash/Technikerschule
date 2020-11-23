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
public class CalcResi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int Farbcode1 = 0;
        int Farbcode2 = 0;
        int Farbcode3 = 0;
        int Farbcode4 = 0;
        double toleranz = 0.0;

        Scanner s = new Scanner(System.in);

        System.out.println("CalcResi - das Programm zur Dekodierung des IEC-Farbcodes");
        System.out.println("Farben des 1. und 2. Rings:\n"
                + "0) Schwarz\n"
                + "1) Braun\n"
                + "2) Rot\n"
                + "3) orange\n"
                + "4) gelb\n"
                + "5) Grün\n"
                + "6) Blau\n"
                + "7) Violett\n"
                + "8) Grau\n"
                + "9) Weiß");

        Farbcode1 = s.nextInt();
        Farbcode2 = s.nextInt();

        System.out.println("Farben des 3. Rings:\n"
                + "1) Silber\n"
                + "2) Gold\n"
                + "3) Schwarz\n"
                + "4) Braun\n"
                + "5) Rot\n"
                + "6) Orange\n"
                + "7) Gelb\n"
                + "8) Grün\n"
                + "9) Blau\n"
                + "10) Violett\n"
                + "11) Grau\n"
                + "12) Weiß");

        Farbcode3 = s.nextInt();

        System.out.println("Farben des 4. Rings:\n"
                + "1) Keine\n"
                + "2) Silber\n"
                + "3) Gold\n"
                + "4) Braun\n"
                + "5) Rot\n"
                + "6) Grün");
        Farbcode4 = s.nextInt();

        double R = (Farbcode1 * 10) + Farbcode2;

        switch (Farbcode3) {
            case 1:
                R = R * 0.01;
                break;
            case 2:
                R = R * 0.1;
                break;
            case 3:
                R = R * 1;
                break;
            case 4:
                R = R * 10;
                break;
            case 5:
                R = R * 100;
                break;
            case 6:
                R = R * 1000;
                break;
            case 7:
                R = R * Math.pow(10, 4);
                break;
            case 8:
                R = R * Math.pow(10, 5);
                break;
            case 9:
                R = R * Math.pow(10, 6);
                break;
            case 10:
                R = R * Math.pow(10, 7);
                break;
            case 11:
                R = R * Math.pow(10, 8);
                break;
            case 12:
                R = R * Math.pow(10, 9);
                break;
        }

        switch (Farbcode4) {
            case 1:
                toleranz = 20;
                break;
            case 2:
                toleranz = 10;
                break;
            case 3:
                toleranz = 5;
                break;
            case 4:
                toleranz = 1;
                break;
            case 5:
                toleranz = 2;
                break;
            case 6:
                toleranz = 0.5;
                break;
        }
        System.out.println("R (Ohm) " + R + " und Toleranz " + toleranz + " %");
    }

}
