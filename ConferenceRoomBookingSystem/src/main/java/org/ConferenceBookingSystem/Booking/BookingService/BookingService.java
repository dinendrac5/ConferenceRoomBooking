package org.ConferenceBookingSystem.Booking.BookingService;

import org.ConferenceBookingSystem.Building.BuildingModel.Building;
import org.ConferenceBookingSystem.Floor.FloorModel.Floor;
import org.ConferenceBookingSystem.TimeSlot.TimeSlot;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

import java.util.Optional;

public interface BookingService {
    
    ConferenceRoom createNewBooking(Optional<Building> building, Optional<Floor> floor, TimeSlot slot, Optional<ConferenceRoom> conferenceRoom, int capacity);

    ConferenceRoom updateBooking(Optional<Building> building, Optional<Floor> floor, TimeSlot slot, Optional<ConferenceRoom> conferenceRoom, int capacity);

    void deleteBooking(int id);
}
