package DTO;

public class Medlem {
    private int id;
    private String aNamn;
    private String losen;
    private Person person;

    public Medlem() {
    }

    public Medlem(int id, String aNamn, String losen, Person person) {
        this.id = id;
        this.aNamn = aNamn;
        this.losen = losen;
        this.person = person;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Medlem{" +
                "id=" + id +
                ", person=" + person.getNamn()+" "+person.getPersonNummer() +
                '}';
    }
}
