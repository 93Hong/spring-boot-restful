package com.example.demo;

/**
 * Created by hong on 2017-07-09.
 */
public class HotelBooking {
    private String hotelName;
    private double pricePerNight;
    private int nbOfNights;

    public HotelBooking() {}

    public HotelBooking(String hotelName, double pricePerNight, int nbOfNights) {
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.nbOfNights = nbOfNights;
    }

    public String getHotelName() {
        return hotelName;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNbOfNights() {
        return nbOfNights;
    }

    public double getTotalPrice() {
        return pricePerNight * nbOfNights;
    }
}
