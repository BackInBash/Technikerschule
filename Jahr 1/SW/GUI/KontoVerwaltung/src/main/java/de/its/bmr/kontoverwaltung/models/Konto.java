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
public class Konto {

    protected double guthaben;
    protected Timestamp kontoErstellt = 
            new Timestamp(System.currentTimeMillis());
    protected float kontonummer;

    public double getGuthaben() {
        return guthaben;
    }

    public void addGuthaben(double guthaben) {
        this.guthaben = +guthaben;
    }

    public void removeGuthaben(double guthaben) {
        this.guthaben = -guthaben;
    }

    public Timestamp getKontoErstellt() {
        return kontoErstellt;
    }

    public float getKontonummer() {
        return kontonummer;
    }

}
