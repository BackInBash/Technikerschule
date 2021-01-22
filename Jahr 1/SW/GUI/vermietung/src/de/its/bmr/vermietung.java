/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.bmr;

/**
 *
 * @author markus
 */
public class vermietung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Unterkunft.setFruehstueckspreis(8);
        Zimmer.setTagespreis(85);
        Zimmer z = new Zimmer(true, 13, false);
        z.setAlsEinzelzimmer(true);
        z.setAnzahlTage(7);
        
        System.out.println("Zimmer: "+z.uebernachtungspreisBerechnen());
        
        Ferienwohnung.setWochenpreis(685);
        Ferienwohnung f = new Ferienwohnung(4, 4711, false);
        f.setAnzahlWochen(2);
        
        System.out.println("Ferienwohnung: "+f.uebernachtungspreisBerechnen());
        
    }
    
}
