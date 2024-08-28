package org.ConferenceBookingSystem.Booking.BookingRepository;

import org.ConferenceBookingSystem.Booking.BookingModel.Booking;
import org.ConferenceBookingSystem.TimeSlot.TimeSlot;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

import java.util.ArrayList;
import java.util.List;

public class BookingRepository implements IBookingRepository {


    private List<Booking> bookings;

    public BookingRepository() {
        this.bookings = new ArrayList<>();
    }


    @Override
    public Booking findById(int id) {
        return this.bookings.stream().filter(booking -> booking.getBookingId() == id).findFirst().orElse(null);
    }

    @Override
    public Booking findBySlot(TimeSlot slot) {
        return this.bookings.stream().filter(booking -> booking.getSlot() == slot).findFirst().orElse(null);
    }

    @Override
    public Booking findByConfRoom(ConferenceRoom conferenceRoom) {
        return this.bookings.stream().filter(booking -> booking.getConfRoom().getId() == conferenceRoom.getId()).findFirst().orElse(null);
    }


    @Override
    public void createBooking(Booking booking) {
        this.bookings.add(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        for (int i = 0; i <= bookings.size(); i++) {
            if (bookings.get(i).getBookingId() == booking.getBookingId()) {
                bookings.set(i, booking);
            }
        }
    }

    @Override
    public void deleteBooking(int id) {
        this.bookings.removeIf(booking -> booking.getBookingId() == id);
    }
}
