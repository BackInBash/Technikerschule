package de.its.fti1;

/**
 *
 * @author FTI1
 */
public class Girokonto extends Sparkonto {

    private double dispohoehe;

    public Girokonto(int KONTONUMMER, double dispohoehe, double habenzins) {
        super(KONTONUMMER, habenzins);
        this.dispohoehe = dispohoehe;
    }

    @Override
    public void abrechnen() {
        if (getGuthaben() >= 0) {
            addGuthaben(getGuthaben() * 0.025 / 365);
        } else {
            removeGuthaben(getGuthaben() * 0.1199 / 365);
        }
    }

    public double getDispohoehe() {
        return dispohoehe;
    }

    public void setDispohoehe(double dispohoehe) {
        this.dispohoehe = dispohoehe;
    }

    @Override
    public boolean pruefeAbhebung(double betrag) {
        if ((getGuthaben() - betrag) >= -dispohoehe) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getTyp() {
        return "Girokonto";
    }
}
