package de.its.fti1;

/**
 *
 * @author FTI1
 */
public class Festgeldkonto extends Konto {

    private int laufzeit;

    public Festgeldkonto(int KONTONUMMER, int laufzeit, double startGuthaben) {
        super(KONTONUMMER, startGuthaben);
        setLaufzeit(laufzeit);
    }

    @Override
    public void abrechnen() {
        if (getLaufzeit() > 0 && getGuthaben() >= 5000) {
            switch (laufzeit) {
                // Abrechnung pro Tag ==> Guthaben * Zinssatz / Tage 
                case 6:
                    addGuthaben(getGuthaben() * 0.04 / 365);
                case 12:
                    addGuthaben(getGuthaben() * 0.045 / 365);
                case 24:
                    addGuthaben(getGuthaben() * 0.05 / 365);
            }
        }
    }

    public int getLaufzeit() {
        return laufzeit;
    }

    public void setLaufzeit(int laufzeit) {
        if (laufzeit == 6 || laufzeit == 12 || laufzeit == 24) {
            this.laufzeit = laufzeit;  // this.lauzeit ist attribute. nur laufzeit ist methode

        } else {
            this.laufzeit = 6; // wenn falsche Laufzeit gesetzt werden soll, wird diese auf 6 gesetzt
        }
    }

    @Override
    public boolean pruefeAbhebung(double betrag) {
        if ((getGuthaben() - betrag) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void ueberweise(double betrag, Konto zielKonto) {
        if (zielKonto instanceof Girokonto) {
            super.ueberweise(betrag, zielKonto);
        }
    }

    @Override
    public String getTyp() {
        return "Festgeldkonto";
    }
}
