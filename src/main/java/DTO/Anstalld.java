package DTO;

public class Anstalld {
    private int id;
    private String aNamn;
    private String losen;
    private Behorighet behörighet;
    private PersonalRegister pRegister;

    public Anstalld() {
    }
    
    public Anstalld(int id, String aNamn, String losen, Behorighet behörighet, PersonalRegister pRegister) {
        this.id = id;
        this.aNamn = aNamn;
        this.losen = losen;
        this.behörighet = behörighet;
        this.pRegister = pRegister;
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

    public Behorighet getBehörighet() {
        return behörighet;
    }

    public void setBehörighet(Behorighet behörighet) {
        this.behörighet = behörighet;
    }

    public PersonalRegister getpRegister() {
        return pRegister;
    }

    public void setpRegister(PersonalRegister pRegister) {
        this.pRegister = pRegister;
    }

    
    
}
