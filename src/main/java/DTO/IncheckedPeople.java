package DTO;

public class IncheckedPeople {

    int id;
    Medlem medlem;
    Pass pass;

    public IncheckedPeople(int id, Medlem medlem, Pass pass) {
        this.id = id;
        this.medlem = medlem;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medlem getMedlem() {
        return medlem;
    }

    public void setMedlem(Medlem medlem) {
        this.medlem = medlem;
    }

    public Pass getPass() {
        return pass;
    }

    public void setPass(Pass pass) {
        this.pass = pass;
    }
}
