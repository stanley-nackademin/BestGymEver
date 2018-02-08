package DTO;

public class Sal {
    private int id;
    private String namn;

    public Sal(int id, String namn, int platser) {
    }

    public Sal(int id, String namn) {
        this.id = id;
        this.namn = namn;
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
}
