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
public abstract class Uhr extends Zeit {
    private boolean sommerzeit;
    
    public Uhr(Zeit zeit){
        super(zeit.getStunde(), zeit.getMinute());
    }
    
    public void setSommerzeit(boolean sommer){
        this.sommerzeit = sommer;
    }
    
    public boolean isSommerzeit(){
        return this.sommerzeit;
    }
    
    public String getAusgabe(){
        return "Uhrzeit "+getStunde()+":"+getMinute();
    }
}
