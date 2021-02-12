package de.its.fti1;

/**
 *
 * @author FTI1
 */
public abstract class Konto {

    private double guthaben;
    private final int KONTONUMMER;

    public Konto(int KONTONUMMER, double startGuthaben) {
        this.guthaben = startGuthaben;
        this.KONTONUMMER = KONTONUMMER;
    }

    public Konto(int KONTONUMMER) {
        this(KONTONUMMER, 0.0);
    }

    public double getGuthaben() {
        return guthaben;
    }

    public int getKontonummer() {
        return KONTONUMMER;
    }

    public void addGuthaben(double betrag) {
        this.guthaben += betrag;
    }

    public boolean removeGuthaben(double betrag) {
        if (pruefeAbhebung(betrag) == true) {
            this.guthaben = this.guthaben - betrag;
            return true;
        } else {
            return false;
        }
    }

    public void ueberweise(double betrag, Konto zielKonto) {
        if (this.removeGuthaben(betrag)) {
            zielKonto.addGuthaben(betrag);
        }
    }

    public abstract void abrechnen();

    public abstract boolean pruefeAbhebung(double betrag);

    public abstract String getTyp();
    
    public String toString(){
        return getTyp() +" Nr."+ getKontonummer() +" Guthaben: "+getGuthaben()+" €";
    }
}
