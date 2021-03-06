package DTO;

public class Traningstyp {
    private int id;
    private String namn;

    
    public Traningstyp() {
    }

    public Traningstyp(int id, String namn) {
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
    
    public void print(){
        System.out.format("- %s\n", namn);
    }
}
