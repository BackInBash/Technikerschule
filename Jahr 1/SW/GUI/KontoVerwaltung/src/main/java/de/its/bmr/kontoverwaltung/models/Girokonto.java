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
public class Girokonto extends Sparkonto {

    private final double dispokredit = 0.01199;
    private final double zinsen = 0.0025;
    
    private double dispohoehe = 0;

    public void setDispohoehe(double dispo){
        dispohoehe = dispo;
    }
    
    // -11.99% Dispo pro Tag
    private void addDispo() {
        this.removeGuthaben((this.getGuthaben() * dispokredit));
    }

    // +0.25% Zinsen pro Tag
    private void addZinsen() {
        if (this.getGuthaben() > 0) {
            this.addGuthaben(this.getGuthaben() * zinsen);
        }
    }
    
    public void abrechnen(){
        if(this.getGuthaben()>0){
            addZinsen();
        }
        else{
            addDispo();
        }
    }
    
    public void ueberweisen(double betrag, Konto dest){
        if((this.getGuthaben()-betrag)>dispohoehe){
            this.removeGuthaben(betrag);
            dest.addGuthaben(betrag);
        }
    }
}
