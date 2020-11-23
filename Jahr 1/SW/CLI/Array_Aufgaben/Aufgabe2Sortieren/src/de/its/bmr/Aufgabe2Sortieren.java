/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.bmr;

import java.util.Random;

/**
 *
 * @author markus
 */
public class Aufgabe2Sortieren {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] zahlen = new int[10];
        Random rnd = new Random();

        for (int i = 0; i < zahlen.length; i++) {
            zahlen[i] = rnd.nextInt(10);
            System.out.println(zahlen[i]);
        }

        System.out.println("");
        
        for (int i = 0; i < zahlen.length/2; i++) {
            int current = zahlen[i];
            int swap = zahlen[zahlen.length - 1 - i];
            
            zahlen[i] = swap;
            zahlen[zahlen.length -1 - i] = current;
        }
        
        for (int i = 0; i < zahlen.length; i++) {
            System.out.println(zahlen[i]);
        }
    }
}
