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
public class Dreieck extends GeometrischeFigur {

    private double grundlinie;
    private double hoehe;

    public double getGrundlinie() {
        return grundlinie;
    }

    public void setGrundlinie(double grundlinie) {
        this.grundlinie = grundlinie;
    }

    public double getHoehe() {
        return hoehe;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }

    @Override
    public double berechneFlaecheninhalt() {
        double flaecheninhalt = (grundlinie * hoehe) / 2;

        return flaecheninhalt;
    }
    
    public String toString(){
        return "Dreieck "+getHoehe()+" x "+getGrundlinie();
    }
}
