package org.ConferenceBookingSystem.Booking.BookingModel;

import org.ConferenceBookingSystem.Building.BuildingModel.Building;
import org.ConferenceBookingSystem.Floor.FloorModel.Floor;
import org.ConferenceBookingSystem.TimeSlot.TimeSlot;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;
import org.ConferenceBookingSystem.user.UserModel.User;

public class Booking {

    int bookingId;

    User user;

    Building building;

    Floor floor;

    ConferenceRoom confRoom;

    TimeSlot slot;


}
