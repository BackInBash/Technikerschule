/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.fti;

/**
 *
 * @author lorenz
 */
public class Kreis extends GeometrischeFigur{
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double berechneFlaecheninhalt() {
       double flaecheninhalt = Math.PI * radius *radius;
       return flaecheninhalt;
    }
    
    public String toString(){
        return "Kreis "+getRadius();
    }
}
