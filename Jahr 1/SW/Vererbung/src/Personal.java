public class Personal {
    private String vorname;
    private String nachname;
    private String adresse;

    public void setVorname(String vorname){
        this.vorname = vorname;
    }

    public void setNachname(String nachname){
        this.nachname = nachname;
    }

    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    public String getVorname(){
        return vorname;
    }

    public String getNachname(){
        return nachname;
    }

    public String getAdresse(){
        return adresse;
    }

    public int monatsgehalt(){
        return 0;
    }
}
