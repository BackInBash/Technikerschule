/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.bmr;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author markus
 */
public class TelCalc {

    /**
     * @param args the command line arguments
     */
    public static int zeitraum = 12;
    public static double[] daten = new double[zeitraum];
    public static Scanner s = new Scanner(System.in);

    // Main Menu
    public static int MainMenu() {
        System.out.println(",--------.      ,--. ,-----.        ,--.       \n"
                + "'--.  .--',---. |  |'  .--./ ,--,--.|  | ,---. \n"
                + "   |  |  | .-. :|  ||  |    ' ,-.  ||  || .--' \n"
                + "   |  |  \\   --.|  |'  '--'\\\\ '-'  ||  |\\ `--.     Die\n"
                + "   `--'   `----'`--' `-----' `--`--'`--' `---'     Telefonkostensoftware");

        System.out.println("1) Eingabe der monatlichen Handykosten");
        System.out.println("2) Ausgabe der monatlichen Handykosten");
        System.out.println("3) Ausgabe der Jahreskosten");
        System.out.println("4) Ausgabe der durchschnittlichen Kosten pro Monat");
        System.out.println("5) Ausgabe der durchschnittlichen Kosten pro Tag\n");
        System.out.println("0) Programm beenden\n");
        System.out.println("Bitte geben Sie die Nummer des gewünschten Menüpunkts ein:");
        return s.nextInt();
    }

    // Eingabe von Handykosten
    public static void Eingabe() {
        for (int i = 0; i < zeitraum; i++) {
            System.out.println("Bitte geben Sie ihre Handykosten für den " + (i + 1) + " Monat ein:");
            daten[i] = s.nextDouble();
        }
    }

    // Ausgabe der Monats Handykosten
    public static void AusgabenMonat() throws IOException {
        for (int i = 0; i < zeitraum; i++) {
            System.out.println("Ihre Handykosten für den " + (i + 1) + " Monat betrugen: " + daten[i]);
        }
        System.out.println("Belibige Eingabe zum Fortfahren.");
        System.in.read();
    }

    // Ausgabe der Jahres Handykosten
    public static void AusgabenJahr() throws IOException {
        double betrag = 0;
        for (int i = 0; i < zeitraum; i++) {
            betrag = betrag+ daten[i];
        }
        System.out.println("\nIhre Handykosten für das gesammte Jahr betrugen: " + betrag);
        
        System.out.println("\nBelibige Eingabe zum Fortfahren.");
        System.in.read();
    }

    //Durchnittliche Monatskosten
    public static void DurchschnittMonat() throws IOException {
        double betrag = 0;
        for (int i = 0; i < zeitraum; i++) {
            betrag = betrag+daten[i];
        }
        System.out.println("Ihre durchschnittlichen Handykosten pro Monat betrugen: " + String.format("%1$,.2f",betrag / zeitraum));
        
        System.out.println("\nBelibige Eingabe zum Fortfahren.");
        System.in.read();
    }

    // Durchschnittliche Tages Kosten
    public static void DurchschnittTag() throws IOException {
        double betrag = 0;
        for (int i = 0; i < zeitraum; i++) {
            betrag = betrag+(daten[i]);
        }
        System.out.println("Ihre durchschnittlichen Handykosten pro Tag betrugen: " + String.format("%1$,.2f", betrag / 365));
        
        System.out.println("\nBelibige Eingabe zum Fortfahren.");
        System.in.read();
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        for (;;) {
            switch (MainMenu()) {
                case 1:
                    Eingabe();
                    break;
                case 2:
                    AusgabenMonat();
                    break;
                case 3:
                    AusgabenJahr();
                    break;
                case 4:
                    DurchschnittMonat();
                    break;
                case 5:
                    DurchschnittTag();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
