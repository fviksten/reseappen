package com.sallskapsresan;

/**
 * Created by Administrator on 2016-10-20.
 */
public class Destination {

    private int id;
    private String country;

    public Destination(int id, String country) {
        this.id = id; this.country = country;
    }

    public void setId (int id) {
        this.id = id;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public int getId () {
        return id;
    }

    public String getCountry() {
        return country;
    }

}
