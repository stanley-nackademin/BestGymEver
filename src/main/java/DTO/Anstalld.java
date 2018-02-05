package DTO;

public class Anstalld {
    private int id;
    private String aNamn;
    private String losen;
    private int behörighet;
    private int personalRegister;

    public Anstalld() {
    }

    public Anstalld(int id, String aNamn, String losen, int behörighet, int personalRegister) {
        this.id = id;
        this.aNamn = aNamn;
        this.losen = losen;
        this.behörighet = behörighet;
        this.personalRegister = personalRegister;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getaNamn() {
        return aNamn;
    }

    public void setaNamn(String aNamn) {
        this.aNamn = aNamn;
    }

    public String getLosen() {
        return losen;
    }

    public void setLosen(String losen) {
        this.losen = losen;
    }

    public int getBehörighet() {
        return behörighet;
    }

    public void setBehörighet(int behörighet) {
        this.behörighet = behörighet;
    }

    public int getPersonalRegister() {
        return personalRegister;
    }

    public void setPersonalRegister(int personalRegister) {
        this.personalRegister = personalRegister;
    }
    
    
}
