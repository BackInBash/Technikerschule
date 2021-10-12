package its.sw;

/**
 *
 * @author Oliver Schwahlen
 */
public class AppController {

    private Temperatur temperatur = null;
    private CelsiusGUI celsiusGUI = null;
    private FahrenheitGUI fahrenheitGUI = null;
    private TermometerGUI termometerGUI = null;

    private void initController() {
        this.temperatur = new Temperatur();

        this.celsiusGUI = new CelsiusGUI(this.temperatur);
        this.temperatur.addObserver(this.celsiusGUI);
        this.celsiusGUI.setVisible(true);

        this.fahrenheitGUI = new FahrenheitGUI(this.temperatur);
        this.temperatur.addObserver(this.fahrenheitGUI);
        this.fahrenheitGUI.setVisible(true);

        this.termometerGUI = new TermometerGUI(this.temperatur);
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
