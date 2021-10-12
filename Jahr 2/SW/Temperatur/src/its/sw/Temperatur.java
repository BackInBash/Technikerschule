package its.sw;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Oliver Schwahlen
 */
public class Temperatur {

    private final PropertyChangeSupport propertyChangeSupport;
    private double temperatur = 0.0;

    public Temperatur() {
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

    /**
     * @param temperatur the temperatur to set
     */
    public void setCelsius(double temperatur) {
        this.temperatur = temperatur;
        propertyChangeSupport.firePropertyChange("Temperatur", 0, 1);
    }

    /**
     * @param temperatur the temperatur to set
     */
    public void setFahrenheit(double temperatur) {
        this.temperatur = (temperatur - 32) * 5 / 9;
        propertyChangeSupport.firePropertyChange("Temperatur", 0, 1);
    }
}
