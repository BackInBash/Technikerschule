package de.its.bmr;

/**
 *
 * @author Sw
 */
public class Ferienwohnung extends Unterkunft {

    private int anzahlWochen;
    private static double wochenpreis;
    private int maxPersonen;
    private static double endreinigungsgebühr;

    public Ferienwohnung(int maxPersonen, int nummer, boolean behindertengerecht) {
        super(nummer, behindertengerecht);
        this.maxPersonen = maxPersonen;
    }

    public int getAnzahlWochen() {
        return anzahlWochen;
    }

    public void setAnzahlWochen(int anzahlWochen) {
        this.anzahlWochen = anzahlWochen;
    }

    public static double getWochenpreis() {
        return wochenpreis;
    }

    public static void setWochenpreis(double wochenpreis) {
        Ferienwohnung.wochenpreis = wochenpreis;
    }

    public int getMaxPersonen() {
        return maxPersonen;
    }

    public void setMaxPersonen(int maxPersonen) {
        this.maxPersonen = maxPersonen;
    }

    public static double getEndreinigungsgebühr() {
        return endreinigungsgebühr;
    }

    public static void setEndreinigungsgebühr(double endreinigungsgebühr) {
        Ferienwohnung.endreinigungsgebühr = endreinigungsgebühr;
    }
    
    @Override
    public double uebernachtungspreisBerechnen(){
        double preis = 0;
        
        // Berechne Frühstück
        if(this.isFruehstueck()){
            preis += getFruehstueckspreis()*getMaxPersonen();
        }
        
        // Berechne Endpreis
        preis += 40;
        
        // Berechen Wochenpreis
        preis += this.getAnzahlWochen()*getWochenpreis();
        
        return preis;
    }

}
