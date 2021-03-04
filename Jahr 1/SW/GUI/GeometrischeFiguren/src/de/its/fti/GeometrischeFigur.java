package de.its.fti;

import java.awt.Color;

/**
 *
 * @author lorenz
 */
public abstract class GeometrischeFigur {

    enum lineart {
        VOLL,
        GEPUNKTET,
        GESTRICHELT
    }

    private Color farbe;

    public Color getFarbe() {
        return farbe;
    }

    public void setFarbe(Color farbe) {
        this.farbe = farbe;
    }

    public abstract double berechneFlaecheninhalt();

}
