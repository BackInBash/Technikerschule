package de.its.fti;

import java.awt.Color;
import java.util.UUID;

/**
 *
 * @author lorenz
 */
public abstract class GeometrischeFigur {

    private Color farbe;

    public Color getFarbe() {
        return farbe;
    }

    public void setFarbe(Color farbe) {
        this.farbe = farbe;
    }
      
    public abstract double berechneFlaecheninhalt();

}
