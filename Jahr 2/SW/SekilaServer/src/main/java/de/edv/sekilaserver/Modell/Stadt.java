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
public class Stadt {

    protected int city_ID;
    protected String city_Bezeichnung;
    protected Action action;

    public int getCity_ID() {
        return city_ID;
    }

    public void setCity_ID(int city_ID) {
        this.city_ID = city_ID;
    }

    public String getCity_Bezeichnung() {
        return city_Bezeichnung;
    }

    public void setCity_Bezeichnung(String city_Bezeichnung) {
        this.city_Bezeichnung = city_Bezeichnung;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return action;
    }

    @Override
    public String toString() {
        return " " + String.valueOf(city_ID) + ":   " + String.valueOf(city_Bezeichnung);
    }
}
