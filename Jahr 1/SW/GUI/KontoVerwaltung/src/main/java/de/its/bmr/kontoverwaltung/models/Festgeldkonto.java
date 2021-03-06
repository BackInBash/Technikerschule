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
public class Festgeldkonto extends Sparkonto {

    // Laufzeit in Monaten
    private int laufzeit;
    // Zeitpunkt der Buchung
    private Timestamp booking = this.getKontoErstellt();

    public Festgeldkonto(int laufzeit) {
        laufzeit = laufzeit;
    }

    public boolean timeExeeded() {
        Timestamp current = new Timestamp(System.currentTimeMillis());
        int verstricheneMonate
                = ((int) java.time.Duration.between(
                        booking.toLocalDateTime(),
                        current.toLocalDateTime()).toDays()) / 30;

        if (laufzeit <= verstricheneMonate) {
            return true;
        }
        return false;
    }

    public void ueberweisen(double betrag, Konto dest) {
        if (timeExeeded() && (this.getGuthaben() - betrag) >= 0) {
            this.removeGuthaben(betrag);
            dest.addGuthaben(betrag);
        }
    }

    public void abrechnen(){
        addZinsen();
    }
    
    public void addZinsen() {
        if (timeExeeded()) {
            switch (laufzeit) {
                case 6:
                    // 6 Monate + 4%
                    this.addGuthaben(this.getGuthaben() * 0.04);
                    break;
                case 12:
                    // 12 Monate + 4.5%
                    this.addGuthaben(this.getGuthaben() * 0.045);
                    break;
                case 24:
                    // 24 Monate + 5%
                    this.addGuthaben(this.getGuthaben() * 0.05);
                    break;
            }
        }
    }
}
