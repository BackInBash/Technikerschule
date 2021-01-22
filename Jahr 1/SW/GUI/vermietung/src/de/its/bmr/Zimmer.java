package de.its.bmr;

/**
 *
 * @author Sw
 */
public class Zimmer extends Unterkunft {

    private int anzahlTage;
    private boolean meerblick;
    private static double tagespreis;
    private boolean alsEinzelzimmer;

    public Zimmer(boolean meerblick, int nummer, boolean behindertengerecht) {
        super(nummer, behindertengerecht);
        this.meerblick = meerblick;
    }

    public int getAnzahlTage() {
        return anzahlTage;
    }

    public void setAnzahlTage(int anzahlTage) {
        this.anzahlTage = anzahlTage;
    }

    public boolean isMeerblick() {
        return meerblick;
    }

    public void setMeerblick(boolean meerblick) {
        this.meerblick = meerblick;
    }

    public static double getTagespreis() {
        return Zimmer.tagespreis;
    }

    public static void setTagespreis(double tagespreis) {
        Zimmer.tagespreis = tagespreis;
    }

    public boolean isAlsEinzelzimmer() {
        return alsEinzelzimmer;
    }

    public void setAlsEinzelzimmer(boolean alsEinzelzimmer) {
        this.alsEinzelzimmer = alsEinzelzimmer;
    }
    
    @Override
    public double uebernachtungspreisBerechnen(){
        double preis = 0;
        
        // Berechen Frühstück
        if(this.isFruehstueck() && this.isAlsEinzelzimmer()){
            preis += this.getAnzahlTage()*getFruehstueckspreis();
        }
        
        if(this.isFruehstueck() && !this.isAlsEinzelzimmer()){
            preis += this.getAnzahlTage()*(getFruehstueckspreis()*2);
        }
        
        // Bereche Meerblick
        if(this.isMeerblick()){
            preis += 10;
        }
        
        // Doppelzimmer für eine Person
        if(this.isAlsEinzelzimmer()){
            preis =- 30;
        }
        
        // Berechne Preis
        preis =+ this.getAnzahlTage()*getTagespreis();
        
        return preis;
    }

}
