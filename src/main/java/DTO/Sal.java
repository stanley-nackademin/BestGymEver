package DTO;

public class Sal {
    private int id;
    private String namn;
    private int platser;

    public Sal() {
    }

    public Sal(int id, String namn, int platser) {
        this.id = id;
        this.namn = namn;
        this.platser = platser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public int getPlatser() {
        return platser;
    }

    public void setPlatser(int platser) {
        this.platser = platser;
    }
    
}
