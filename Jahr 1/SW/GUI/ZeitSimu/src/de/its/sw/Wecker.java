/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.sw;

/**
 *
 * @author BackInBash
 */
public class Wecker extends Uhr {
    public Wecker(Zeit zeit, Zeit weckzeit){
        super(weckzeit);
    }
    
    
    public String getAusgabe(){
        return "Uhrzeit: "+getStunde()+":"+getMinute()+" Weckzeit: ???";
    }
}
