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
public class Aufgabe3Bubblesort {

    // Check Value Helper
    public static boolean greater(int a, int b) {
        if (a > b) {
            return true;
        }
        return false;
    }
    
    // Swap Array Value Helper
    public static void swap(int[] array, int i, int j){
        int swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }

    // Bubble Sort Algorithm
    public static <T extends Comparable<T>> int[] sort(int[] array) {
        for (int i = 0, size = array.length; i < size - 1; ++i) {
            boolean swapped = false;
            for (int j = 0; j < size - 1 - i; ++j) {
                if (greater(array[j], array[j + 1])) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }

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
        
        for (int i = 0; i < zahlen.length; i++) {
            sort(zahlen);
            System.out.println(zahlen[i]);
        }
    }

}
