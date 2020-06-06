package com.blog.pojo;

public class Ar_la {

    private int id;
    private int ar_id;
    private int la_id;

    public Ar_la() {
        super();
    }

    @Override
    public String toString() {
        return "Ar_la{" +
                "id=" + id +
                ", ar_id=" + ar_id +
                ", la_id=" + la_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAr_id() {
        return ar_id;
    }

    public void setAr_id(int ar_id) {
        this.ar_id = ar_id;
    }

    public int getLa_id() {
        return la_id;
    }

    public void setLa_id(int la_id) {
        this.la_id = la_id;
    }
}
