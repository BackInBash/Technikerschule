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
public class Rechteck extends GeometrischeFigur {

    private double breite;
    private double hoehe;

    public double getBreite() {
        return breite;
    }

    public void setBreite(double breite) {
        this.breite = breite;
    }

    public double getHoehe() {
        return hoehe;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }

    @Override
    public double berechneFlaecheninhalt() {
        double flaecheninhalt = hoehe * breite;
        return flaecheninhalt;
    }
    
    public String toString(){
        return "Rechteck "+getHoehe()+" x "+getBreite();
    }
}
