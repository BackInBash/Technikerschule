public class Arbeiter extends Personal {
    private int stundenLohn;
    private int monatsStunden;

    public void setMonatsStunden(int monatsStunden){
        this.monatsStunden = monatsStunden;
    }

    public void setStundenLohn(int stundenLohn){
        this.stundenLohn = stundenLohn;
    }

    public int monatsgehalt(){
        return stundenLohn*monatsStunden;
    }
}
