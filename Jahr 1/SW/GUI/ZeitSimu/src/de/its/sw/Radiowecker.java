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
public class Radiowecker extends Wecker {
    private int senderFreq;
    
    public Radiowecker(Zeit zeit, Zeit weckzeit, int senderFreq){
        super(zeit, weckzeit);
        this.senderFreq = senderFreq;
    }

    public void setSenderFreq(int senderFreq){
        this.senderFreq = senderFreq;
    }
    
    public String getAusgabe(){
        return "Uhrzeit "+getStunde()+":"+getMinute()+ " Weckzeit: ??? kHz"+senderFreq;
    }
}
