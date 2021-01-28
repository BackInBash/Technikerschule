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
public class Girokonto extends Konto {

    private final double dispokredit = 0.01199;
    private final double zinsen = 0.0025;

    // -11.99% Dispo pro Tag
    public void addDispo() {
        this.guthaben = -(this.guthaben * dispokredit);
    }

    // +0.25% Zinsen pro Tag
    public void addZinsen() {
        if (this.guthaben > 0) {
            this.guthaben = +(this.guthaben * zinsen);
        }
    }
}
