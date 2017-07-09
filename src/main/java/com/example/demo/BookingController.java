package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hong on 2017-07-09.
 */
@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    private List<HotelBooking> bookings;

    public BookingController() {
        bookings = new ArrayList<>();

        bookings.add(new HotelBooking("A", 200.50, 3));
        bookings.add(new HotelBooking("B", 90, 4));
        bookings.add(new HotelBooking("C", 140.74, 1));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getAll() {
        return bookings;
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price) {
        return bookings.stream().filter(x -> x.getPricePerNight() <= price).collect(Collectors.toList());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking) {
        bookings.add(hotelBooking);

        return bookings;
    }
}
