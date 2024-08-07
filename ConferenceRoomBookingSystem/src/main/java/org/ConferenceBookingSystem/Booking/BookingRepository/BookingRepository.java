package org.ConferenceBookingSystem.Booking.BookingRepository;

import org.ConferenceBookingSystem.TimeSlot.TimeSlot;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;
import org.ConferenceBookingSystem.user.UserModel.User;

import java.util.List;

public class BookingRepository implements IBookingRepository {


    @Override
    public ConferenceRoom findBookingByUser(User user) {
        return null;
    }

    @Override
    public List<ConferenceRoom> findAllBookingsByBookedSlot(List<TimeSlot> bookedSlot) {
        return List.of();
    }
}
