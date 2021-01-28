/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.bmr.kontoverwaltung.models;

/**
 *
 * @author markus
 */
public class Sparkonto extends Konto {

    private final double zinsen = 0.02;

    public void removeGuthaben(double guthaben) {
        if ((this.guthaben = -guthaben) >= 0) {
            this.guthaben = -guthaben;
        }
    }

    // +0.25% Zinsen pro Tag
    public void addZinsen() {
        if (this.guthaben > 0) {
            this.guthaben = +(this.guthaben * zinsen);
        }
    }
}
