package DTO;


import java.sql.Time;

public class Tidslucka {
    private int id;
    private Time start;
    private Time stop;

    public Tidslucka() {
    }
    
    public Tidslucka(int id, Time start, Time stop) {
        this.id = id;
        this.start = start;
        this.stop = stop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getStop() {
        return stop;
    }

    public void setStop(Time stop) {
        this.stop = stop;
    }
    
    public void print(){
        System.out.format("Tid: %s - %s\n", start.toString(), stop.toString());
    }
}
