package DTO;

public class Notis {
    private int id;
    private String kommentar;
    private Anstalld anstalld;
    private Medlem medlem;

    public Notis() {
    }

    public Notis(int id, String kommentar, Anstalld anstalld, Medlem medlem) {
        this.id = id;
        this.kommentar = kommentar;
        this.anstalld = anstalld;
        this.medlem = medlem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public Anstalld getAnstalld() {
        return anstalld;
    }

    public void setAnstalld(Anstalld anstalld) {
        this.anstalld = anstalld;
    }

    public Medlem getMedlem() {
        return medlem;
    }

    public void setMedlem(Medlem medlem) {
        this.medlem = medlem;
    }  
}
