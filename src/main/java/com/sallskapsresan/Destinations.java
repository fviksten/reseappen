package com.sallskapsresan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-10-20.
 */
public class Destinations {

    private List<Destination> listDestinations;

    public Destinations() {
        this.listDestinations = new ArrayList<>();
    }

    public void setListDestinations(List<Destination> listDestinations) {
        this.listDestinations = listDestinations;
    }

    public List<Destination> getListDestinations() {
        return listDestinations;
    }

//    public List<Integer> getDestinationsID() {
//        List<Integer> destinationsID = new ArrayList<>();
//
//        for (Destination destination : listDestinations) {
//            destinationsID.add(destination.getId());
//        }
//        return destinationsID;
//    }
}
