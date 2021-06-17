package de.its.sw;

import java.util.Comparator;

public class Zeit implements Comparable<Zeit> {

    private int stunde;
    private int minute;

    
    public Zeit(int stunde, int minute) {
        this.stunde = stunde;
        this.minute = minute;
    }

    public int getStunde() {
        return stunde;
    }

    public void setStunde(int stunde) {
        this.stunde = stunde;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public int compareTo(Zeit t) {
        if(Integer.compare(this.stunde, (int)t.stunde) < 1){
            return 0;
        }
        else{
            return Integer.compare(this.minute, (int)t.minute);
        }   
    }
}
