/*
 * The MIT License
 *
 * Copyright 2021 BackInBash.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.edv.sekilaserver.Modell;

/**
 *
 * @author lorenz
 */
public class Land {

    protected int country_ID;
    protected String country_Bezeichnung;
    protected Action action;

    public int getCountry_ID() {
        return country_ID;
    }

    public void setCountry_ID(int country_ID) {
        this.country_ID = country_ID;
    }

    public String getCountry_Bezeichnung() {
        return country_Bezeichnung;
    }

    public void setCountry_Bezeichnung(String country_Bezeichnung) {
        this.country_Bezeichnung = country_Bezeichnung;
    }

    public void setAction(Action action){
        this.action = action;
    }
    
    public Action getAction(){
        return action;
    }
    
    @Override
    public String toString() {
        return " " + String.valueOf(country_ID) + ":   " + String.valueOf(country_Bezeichnung);
    }
}
