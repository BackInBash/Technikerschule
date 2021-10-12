package its.kh;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Oliver Schwahlen
 */
public class Thermometer {

    private final PropertyChangeSupport propertyChangeSupport;
    private double temperatur = 0.0;

    public Thermometer() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener changeListener) {
        propertyChangeSupport.addPropertyChangeListener(changeListener);
    }

    public void removeObserver(PropertyChangeListener changeListener) {
        propertyChangeSupport.removePropertyChangeListener(changeListener);
    }

    /**
     * @return the temperatur
     */
    public double getCelsius() {
        return temperatur;
    }

    /**
     * @return the temperatur
     */
    public double getFahrenheit() {
        return ((temperatur * 9) / 5) + 32;
    }

    public double getKelvin() {
        return temperatur + 273.15;
    }

    /**
     * @param temperatur the temperatur to set
     */
    public void setCelsius(double temperatur) {
        this.temperatur = temperatur;
        changeSupport();
    }

    /**
     * @param temperatur the temperatur to set
     */
    public void setFahrenheit(double temperatur) {
        this.temperatur = (temperatur - 32) * 5 / 9;
        changeSupport();
    }

    public void setKelvin(double temperatur) {
        this.temperatur = temperatur - 273.15;
        changeSupport();
    }

    private void changeSupport() {
        propertyChangeSupport.firePropertyChange("Temperatur", 0, 1);
    }

}
