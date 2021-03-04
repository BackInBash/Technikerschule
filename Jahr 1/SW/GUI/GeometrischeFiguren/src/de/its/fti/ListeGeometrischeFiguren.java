/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.fti;

import java.util.ArrayList;

/**
 *
 * @author Markus
 */
public class ListeGeometrischeFiguren {

    private static ArrayList<GeometrischeFigur> ObjListe = new ArrayList<GeometrischeFigur>();

    public static void add(GeometrischeFigur obj) {
        ObjListe.add(obj);
    }
    
    public static void remove(int id){
        ObjListe.remove(id);
    }
    
    public static ArrayList<GeometrischeFigur> get() {
        return ObjListe;
    }
    
    public static double berechneFlächeninhalt(){
        double inhalt = 0;
        
        for(GeometrischeFigur g: ObjListe){
            inhalt += g.berechneFlaecheninhalt();
        }
        
        return inhalt;
    }
}
