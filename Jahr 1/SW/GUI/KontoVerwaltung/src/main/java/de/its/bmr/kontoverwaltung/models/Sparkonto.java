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


    // +0.25% Zinsen pro Tag
    private void addZinsen() {
        if (this.getGuthaben() > 0) {
            this.addGuthaben((this.getGuthaben() * zinsen));
        }
    }

    public void abrechnen() {
        addZinsen();
    }

    
    public void ueberweisen(double betrag, Konto dest) {
        // From Sparkonto to Girokonto
        if (dest.getClass().getName().equals("Girokonto")) {
            if ((this.getGuthaben() - betrag) >= 0) {
                this.removeGuthaben(betrag);
                dest.addGuthaben(betrag);
            }
        }
    }
}
