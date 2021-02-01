/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.bmr.kontoverwaltung.models;

import java.sql.Timestamp;

/**
 *
 * @author markus
 */
public abstract class Konto {

    private double guthaben;
    private Timestamp kontoErstellt = 
            new Timestamp(System.currentTimeMillis());
    private float kontonummer;

    public double getGuthaben() {
        return guthaben;
    }

    public void addGuthaben(double betrag) {
        this.guthaben = +guthaben;
    }

    public void removeGuthaben(double betrag) {
        this.guthaben = -guthaben;
    }

    public Timestamp getKontoErstellt() {
        return kontoErstellt;
    }

    public float getKontonummer() {
        return kontonummer;
    }
    
    public abstract void abrechnen();
    
    public abstract void ueberweisen(double betrag, Konto dest);
}
