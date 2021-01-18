public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Java Vererbungen");

        Arbeiter p = new Arbeiter();
        p.setAdresse("MusterPlatz");
        p.setVorname("max");
        p.setNachname("mustermann");
        p.setMonatsStunden(110);
        p.setStundenLohn(12);
        System.out.println("Gehalt "+p.getClass().getName()+" " +p.monatsgehalt()+" €");

        Angestellter a = new Angestellter();
        a.setAdresse("MusterPlatz");
        a.setVorname("max");
        a.setNachname("mustermann");
        a.setMonatsGehalt(444);
        System.out.println("Gehalt "+ a.getClass().getName() +" "+a.monatsgehalt()+" €");
    }
}
