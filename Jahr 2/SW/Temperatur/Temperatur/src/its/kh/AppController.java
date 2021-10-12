package its.kh;

/**
 *
 * @author Oliver Schwahlen
 */
public class AppController {

    
    private Thermometer temperatur = null;
    private CelsiusGUI celsiusGUI = null;
    private FahrenheitGUI fahrenheitGUI = null;
    private KelvinGUI kelvinGUI = null;
    private ThermometerGUI termometerGUI = null;

    private void initController() {
        this.temperatur = new Thermometer();

        this.celsiusGUI = new CelsiusGUI(this.temperatur);
        this.temperatur.addObserver(this.celsiusGUI);
        this.celsiusGUI.setVisible(true);

        this.fahrenheitGUI = new FahrenheitGUI(this.temperatur);
        this.temperatur.addObserver(this.fahrenheitGUI);
        this.fahrenheitGUI.setVisible(true);
        
        this.kelvinGUI = new KelvinGUI(this.temperatur);
        this.temperatur.addObserver(this.kelvinGUI);
        this.kelvinGUI.setVisible(true);

        this.termometerGUI = new ThermometerGUI(this.temperatur);
        this.temperatur.addObserver(this.termometerGUI);
        this.termometerGUI.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new AppController().initController();
    }
}
