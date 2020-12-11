/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.backinbash.testformaterlib;

/**
 *
 * @author markus
 */
public class StringFormater {

    // Parse Input String to Lower Case
    public String toLowerCase(String input) {
        return input.toLowerCase();
    }

    // Parse Input String to Upper Case
    public String toUpperCase(String input) {
        return input.toUpperCase();
    }

    // Parse every First Char of Word to Upper Case
    public String toWin98(String input) {

        String[] sub = input.split(" ");
        String out = "";

        for (int i = 0; i<sub.length; i++) {
            out += sub[i].substring(0, 1).toUpperCase() + sub[i].substring(1);
            if((sub.length-1) != i){
                out += " ";
            }
        }
        return out;
    }
}