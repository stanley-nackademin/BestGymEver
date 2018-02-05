package DTO;

public class Person {
    private int id;
    private String namn;
    private String personNummer;

    public Person() {
    }

    public Person(int id, String namn, String personNummer) {
        this.id = id;
        this.namn = namn;
        this.personNummer = personNummer;
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

    public String getPersonNummer() {
        return personNummer;
    }

    public void setPersonNummer(String personNummer) {
        this.personNummer = personNummer;
    }
    
    
}
