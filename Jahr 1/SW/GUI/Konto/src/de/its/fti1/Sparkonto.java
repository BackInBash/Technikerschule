package de.its.fti1;

/**
 *
 * @author FTI1
 */
public class Sparkonto extends Konto {

    private double habenzins;

    public Sparkonto(int KONTONUMMER, double habenzins) {
        super(KONTONUMMER);
        setHabenzins(habenzins);
    }

    @Override
    public void abrechnen() {
        addGuthaben(getGuthaben() * getHabenzins() / 365);
    }

    public double getHabenzins() {
        return habenzins;
    }

    public void setHabenzins(double habenzins) {
        this.habenzins = habenzins;
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
        return "Sparkonto";
    }
}
