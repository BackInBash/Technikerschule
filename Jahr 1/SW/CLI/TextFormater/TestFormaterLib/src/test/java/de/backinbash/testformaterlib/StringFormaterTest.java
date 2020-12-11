/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.backinbash.testformaterlib;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author markus
 */
public class StringFormaterTest {
    
    /**
     * Test of toLowerCase method, of class StringFormater.
     */
    @Test
    public void testToLowerCase() {
        System.out.println("toLowerCase");
        String input = "TO LOWER CASE..";
        StringFormater instance = new StringFormater();
        String expResult = "to lower case..";
        String result = instance.toLowerCase(input);
        System.out.println("Result: "+ result);
        assertEquals(expResult, result);
    }

    /**
     * Test of toUpperCase method, of class StringFormater.
     */
    @Test
    public void testToUpperCase() {
        System.out.println("toUpperCase");
        String input = "to upper case";
        StringFormater instance = new StringFormater();
        String expResult = "TO UPPER CASE";
        String result = instance.toUpperCase(input);
        System.out.println("Result: "+ result);
        assertEquals(expResult, result);
    }

    /**
     * Test of toWin98 method, of class StringFormater.
     */
    @Test
    public void testToWin98() {
        System.out.println("toWin98");
        String input = "to windows 98 d w a ds";
        StringFormater instance = new StringFormater();
        String expResult = "To Windows 98 D W A Ds";
        String result = instance.toWin98(input);
        System.out.println("Result: "+ result);
        assertEquals(expResult, result);
    }
}
