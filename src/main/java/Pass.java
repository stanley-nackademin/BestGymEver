import java.util.Date;

public class Pass {
    private int id;
    private boolean privat;
    private Date datum;
    private int deltagande;
    private Traningstyp traning;
    private Sal sal;
    private Anstalld anstalld;

    public Pass() {
    }

    public Pass(int id, boolean privat, Date datum, int deltagande, Traningstyp traning, Sal sal, Anstalld anstalld) {
        this.id = id;
        this.privat = privat;
        this.datum = datum;
        this.deltagande = deltagande;
        this.traning = traning;
        this.sal = sal;
        this.anstalld = anstalld;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPrivat() {
        return privat;
    }

    public void setPrivat(boolean privat) {
        this.privat = privat;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getDeltagande() {
        return deltagande;
    }

    public void setDeltagande(int deltagande) {
        this.deltagande = deltagande;
    }

    public Traningstyp getTraning() {
        return traning;
    }

    public void setTraning(Traningstyp traning) {
        this.traning = traning;
    }

    public Sal getSal() {
        return sal;
    }

    public void setSal(Sal sal) {
        this.sal = sal;
    }

    public Anstalld getAnstalld() {
        return anstalld;
    }

    public void setAnstalld(Anstalld anstalld) {
        this.anstalld = anstalld;
    }
    
}