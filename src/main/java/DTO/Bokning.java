package DTO;


import java.util.List;

public class Bokning {
    private int id;
    private List<Medlem> medlemmar;
    private Pass pass;

    public Bokning() {
    }

    public Bokning(int id, List<Medlem> medlemmar, Pass pass) {
        this.id = id;
        this.medlemmar = medlemmar;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Medlem> getMedlemmar() {
        return medlemmar;
    }

    public void setMedlemmar(List<Medlem> medlemmar) {
        this.medlemmar = medlemmar;
    }

    public Pass getPass() {
        return pass;
    }

    public void setPass(Pass pass) {
        this.pass = pass;
    }
 
}
