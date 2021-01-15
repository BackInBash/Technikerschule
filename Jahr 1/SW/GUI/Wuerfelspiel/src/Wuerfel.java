/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markus
 */
public class Wuerfel {

    private int zahl = 0;

    public int getZahl() {
        return zahl;
    }

    public void werfen() {
        this.zahl = (int)((Math.random()) * 6 + 1);
    }
}
