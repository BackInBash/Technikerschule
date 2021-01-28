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
    private Timestamp booking = kontoErstellt;

    public Festgeldkonto(int laufzeit) {
        laufzeit = laufzeit;
    }

    public boolean timeExeeded() {
        Timestamp current = new Timestamp(System.currentTimeMillis());
        int verstricheneMonate = 
                ((int) java.time.Duration.between(
                    booking.toLocalDateTime(), 
                        current.toLocalDateTime()).toDays()) / 30;

        if (laufzeit <= verstricheneMonate) {
            return true;
        }
        return false;
    }

    public void addGuthaben(double guthaben) {
        if (guthaben >= 5000) {
            this.guthaben = guthaben;
            booking = new Timestamp(System.currentTimeMillis());
        } else {
            //Throw Exception
        }
    }

    public void removeGuthaben(double guthaben) {
        if (timeExeeded()) {
            this.guthaben = -guthaben;
        } else {
            //Throw Exception
        }
    }

    public void addZinsen() {
        if (timeExeeded()) {
            switch (laufzeit) {
                case 6:
                    // 6 Monate + 4%
                    this.guthaben = +(this.guthaben * 0.04);
                    break;
                case 12:
                    // 12 Monate + 4.5%
                    this.guthaben = +(this.guthaben * 0.045);
                    break;
                case 24:
                    // 24 Monate + 5%
                    this.guthaben = +(this.guthaben * 0.05);
                    break;
            }
        }
    }
}
