package org.ConferenceBookingSystem.Booking.BookingRepository;

import org.ConferenceBookingSystem.TimeSlot.TimeSlot;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;
import org.ConferenceBookingSystem.user.UserModel.User;

import java.util.List;

public interface IBookingRepository {

    ConferenceRoom findBookingByUser(User user);

    List<ConferenceRoom> findAllBookingsByBookedSlot(List<TimeSlot> bookedSlot);

}
