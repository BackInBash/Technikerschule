/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.bmr;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Markus
 */
public class PrimeFactorization {

    public static void pfactors(float n) {

        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                System.out.print(i + " \n");
                n /= i;
            }
        }

        if (n > 2) {
            System.out.print(n);
        }
    }

    public static Vector<Float> primfaktoren(float n) {
        Vector<Float> f = new Vector<Float>();
        if (n == 1) {
            return f;
        }
        float t = 2;
        while (t * t <= n) {
            if (n % t == 0) {
                f.add(t);
                n /= t;
            } else {
                t++;
            }
        }
        f.add(n);
        return f;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("## all prime factors ##");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        float n = scanner.nextFloat();
        System.out.print(("Algorithm 1 printing factors of " + n + " : "));
        pfactors(n);
        System.out.println("");
        System.out.println("Algorithm 2 "+primfaktoren(n));
        scanner.close();
    }
}
