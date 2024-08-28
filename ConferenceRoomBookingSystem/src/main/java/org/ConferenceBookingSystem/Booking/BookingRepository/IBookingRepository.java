package org.ConferenceBookingSystem.Booking.BookingRepository;

import org.ConferenceBookingSystem.Booking.BookingModel.Booking;
import org.ConferenceBookingSystem.TimeSlot.TimeSlot;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

public interface IBookingRepository {

    Booking findById(int id);

    Booking findBySlot(TimeSlot slot);

    Booking findByConfRoom(ConferenceRoom conferenceRoom);

    void createBooking(Booking booking);

    void updateBooking(Booking booking);

    void deleteBooking(int id);
}
